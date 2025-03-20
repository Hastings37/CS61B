import edu.princeton.cs.algs4.*;

public class NBody {
	public static double readRadius(String path){
		// �������ڲ��ض�������İ뾶��Ϣ;
		In in=new In(path);
		if(in==null){
			System.out.println("in ����ʧ��");return -1.0;
		}
		int N=in.readInt();
		double radius=in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String path){
		In in=new In(path);
		if(in==null){
            System.out.println("in ����ʧ��");return null;
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
		// չʾ����һ���������Ϣ��������;
		StdDraw.picture(planet.xxPos,planet.yyPos, "images/"+planet.imgFileName);
		return;
	}

	public static void main(String []args){
		// ���õ�һ������Ϊȷ����ʱ��λ�ã�
		// ����һ������Ϊ��ص�ʱ������Ϣ;
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
		// ���ݵĳ�ʼ������;
		double t=0;
		double [] xForces=new double[N];
		double [] yForces=new double[N];
		// ÿ��������xy ���������ϵ��ܵ���������;
		StdDraw.enableDoubleBuffering();
		// ���û�ͼ����ĳ߶�ΪԲ�����򣬷�Χ�� -radius �� +radius
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
			//���������ͼ��;
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
// Ҳ����ȫ����Ҫת��ΪUTF-8 ����ʽ���б�������;

