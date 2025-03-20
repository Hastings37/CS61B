import edu.princeton.cs.algs4.*;

public class NBody {
	public static double readRadius(String path){
		// 返回其内部特定的宇宙的半径信息;
		In in=new In(path);
		if(in==null){
			System.out.println("in 创建失败");return -1.0;
		}
		int N=in.readInt();
		double radius=in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String path){
		In in=new In(path);
		if(in==null){
            System.out.println("in 创建失败");return null;
        }
		int N=in.readInt();
		double radius=in.readDouble();
		Planet[] planets=new Planet[N];
		for(int i=0;i<N;i++){
			double xPos=in.readDouble();
            double yPos=in.readDouble();
            double xVel=in.readDouble();
            double yVel=in.readDouble();
            double mass=in.readDouble();
            String img=in.readString();
            planets[i]=new Planet(xPos,yPos,xVel,yVel,mass,img);
		}
		return planets;
	}

	public static void draw(Planet planet){
		// 展示出来一个星球的信息是这样的;
		StdDraw.picture(planet.xxPos,planet.yyPos, "images/"+planet.imgFileName);
		return;
	}

	public static void main(String []args){
		// 设置第一个参数为确定的时间位置；
		// 后面一个参数为相关的时间间隔信息;
		double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
		In in=new In(args[2]);
		int N=in.readInt();
		double radius=in.readDouble();
		Planet[] planets=new Planet[N];
		for(int i=0;i<N;i++){
			double xPos=in.readDouble();
			double yPos=in.readDouble();
			double xVel=in.readDouble();
			double yVel=in.readDouble();
			double mass=in.readDouble();
			String img=in.readString();
			planets[i]=new Planet(xPos,yPos,xVel,yVel,mass,img);

		}
		// 内容的初始化操作;
		double t=0;
		double [] xForces=new double[N];
		double [] yForces=new double[N];
		// 每个行星在xy 两个方向上的总的受力数据;
		StdDraw.enableDoubleBuffering();
		// 设置绘图区域的尺度为圆形区域，范围从 -radius 到 +radius
		StdDraw.setScale(-radius, radius);
		// StdDraw.picture(0,0,"images/starfield.jpg");
		while(t<T){
			for(int i=0;i<N;i++){
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}
			for(int i=0;i<N;i++ ){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			//绘制整体的图像;
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");

			for(int i=0;i<N;i++){
				// StdDraw.picture(planets[i].xxPos,planets[i].yyPos, "images/"+planets[i].imgFileName);
				draw(planets[i]);
			}
			StdDraw.show();
			StdDraw.pause(10);
			t+=dt;

		}
		System.out.printf("%d\n",N);
		System.out.printf("%.2e\n",radius);
		for(int i=0;i<N;i++){
			System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}


	}
}
// 也就是全都需要转换为UTF-8 的形式进行编码是吗;

