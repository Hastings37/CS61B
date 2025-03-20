import java.util.Objects;

public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet() {
        this(0, 0, 0, 0, 1, "default.gif");
    }
	public Planet(Planet p){
		// 创建出来一个新的类型的指定的对象是这样的;
		this.xxPos=p.xxPos;
		this.yyPos=p.yyPos;
		this.xxVel=p.xxVel;
		this.yyVel=p.yyVel;
		this.mass=p.mass;
		this.imgFileName=p.imgFileName;  // 对象的属性与参数一样, 所以直接赋值; 对象的属性与参数不一样, 所以要复制.  对象的属性和参数是对象的状态, 所以可以直接复制.   对象的属性和参数是对象的状态, 所以可以直接复制.   对象的属性和参数是对象的状态, 所以可以直接复制.   对象的属性和参数是对象的状态, 所以可以直接
	}
	public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}

	// 计算两个星球之间的距离
	public double calcDistance(Planet other) {
        double dx = this.xxPos - other.xxPos;
        double dy = this.yyPos - other.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }// 这真的很好了

	// 计算两个星球之间的引力大小（数值信息） 恒定是一个正数的状态;
	public double calcForceExertedBy(Planet other) {
		// 计算的是当前的行星收到这个行星的引力的大小状态;
		double dr=calcDistance(other);
		double G=6.67430e-11;
		return (G*mass*other.mass/(dr*dr));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Planet planet = (Planet) o;
		return Double.compare(xxPos, planet.xxPos) == 0 && Double.compare(yyPos, planet.yyPos) == 0 && Double.compare(xxVel, planet.xxVel) == 0 && Double.compare(yyVel, planet.yyVel) == 0 && Double.compare(mass, planet.mass) == 0 && Objects.equals(imgFileName, planet.imgFileName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
	}

	// 指定的行星对我们的在X轴上面的影响效果;
	public double calcForceExertedByX(Planet other){
		/* 根据其x位置的大小信息进行的判断要是位置是小的就是整数 反之就是复数
		*  先是要搞明白这个是别的星球对我的作用的万有引力还是我对别的星球施加的万有引力状态
		* */
		// 计算的对象是传入的行星对我们当前的对象的影响的力的作用大小;
		if(equals(other))return 0.0;
		double dr=calcDistance(other);
		double dx=other.xxPos-xxPos;
		double dy=other.yyPos-yyPos;
		double force=calcForceExertedBy(other);
		return (force*dx/dr);
	}
	// 指定的行星对我们的在Y轴上面的影响效果;
	public double calcForceExertedByY(Planet other){
		if(equals(other))return 0.0;
		double dr=calcDistance(other);
		double dx=other.xxPos-xxPos;
		double dy=other.yyPos-yyPos;
		double force=calcForceExertedBy(other);
		return (force*dy/dr);
    }
	public double calcNetForceExertedByX(Planet [] others){
		int len=others.length;
		double ans=0.0;
		for(int i=0;i<len;i++){
			if(equals(others[i]))continue;
			double dr=calcDistance(others[i]);
			double dx=others[i].xxPos-xxPos;
			double dy=others[i].yyPos-yyPos;
			double force=calcForceExertedBy(others[i]);
			ans+=(force*dx/dr);
		}
		return ans;
	}
	public double calcNetForceExertedByY(Planet [] others){
		int len=others.length;
		double ans=0.0;
		for(int i=0;i<len;i++){
			if(equals(others[i]))continue;
			double dr=calcDistance(others[i]);
			double dx=others[i].xxPos-xxPos;
			double dy=others[i].yyPos-yyPos;
			double force=calcForceExertedBy(others[i]);
			ans+=(force*dy/dr);
		}
		return ans;
	}
	//FAIL: calcNetForceExertedByX(): Expected 133.4 and you gave 133.49

	public double moveDistance(double dt,double da){
		// 随着指定的时间内和特定的加速度下面其走过的距离情况;
		return 0.0;
	}
	public void update(double dt,double fx,double fy){
		// 指定的时间内速度和位置的变化情况;
		// double dx=(xxVel*dt+0.5*(fx/mass)*dt*dt);
		// double dy=(yyVel*dt+0.5*(fy/mass)*dt*dt);
		xxVel=xxVel+(fx/mass)*dt;
		yyVel=yyVel+(fy/mass)*dt;
		double dx=(xxVel*dt);
		double dy=(yyVel*dt);
		xxPos=xxPos+dx;
		yyPos=yyPos+dy;
		return ;
	}




}
