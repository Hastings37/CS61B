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
		// ��������һ���µ����͵�ָ���Ķ�����������;
		this.xxPos=p.xxPos;
		this.yyPos=p.yyPos;
		this.xxVel=p.xxVel;
		this.yyVel=p.yyVel;
		this.mass=p.mass;
		this.imgFileName=p.imgFileName;  // ��������������һ��, ����ֱ�Ӹ�ֵ; ����������������һ��, ����Ҫ����.  ��������ԺͲ����Ƕ����״̬, ���Կ���ֱ�Ӹ���.   ��������ԺͲ����Ƕ����״̬, ���Կ���ֱ�Ӹ���.   ��������ԺͲ����Ƕ����״̬, ���Կ���ֱ�Ӹ���.   ��������ԺͲ����Ƕ����״̬, ���Կ���ֱ��
	}
	public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}

	public double calcDistance(Planet other) {
        double dx = this.xxPos - other.xxPos;
        double dy = this.yyPos - other.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }


	public double calcForceExertedBy(Planet other) {

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

	// 现在的应该是正常的；
	public double calcForceExertedByX(Planet other){

		if(equals(other))return 0.0;
		double dr=calcDistance(other);
		double dx=other.xxPos-xxPos;
		double dy=other.yyPos-yyPos;
		double force=calcForceExertedBy(other);
		return (force*dx/dr);
	}

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
		return 0.0;
	}
	public void update(double dt,double fx,double fy){
		xxVel=xxVel+(fx/mass)*dt;
		yyVel=yyVel+(fy/mass)*dt;
		double dx=(xxVel*dt);
		double dy=(yyVel*dt);
		xxPos=xxPos+dx;
		yyPos=yyPos+dy;
		return ;
	}




}
