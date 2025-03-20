
/** Simpler demo of the In class. */
public class BasicInDemo {
	public static void main(String[] args) {
		// In in = new In("BasicInDemo_input_file.txt");
		In in = new In("../data/3body.txt");
		if(in==null){
			System.out.println("in���󴴽�ʧ��");
			return ;
		}

		/* Every time you call a read method from the In class,
		 * it reads the next thing from the file, assuming it is
		 * of the specified type. */

		/* Compare the calls below to the contents of BasicInDemo_input_file.txt */

		int count=in.readInt();
		double radius=in.readDouble();
		for(int i=0;i<count;i++){
			// �ڲ������ݵĴ洢����Ҫ�ϸ���ָ���ķ�ʽ���е�;
			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String path=in.readString();
			System.out.println("Particle: " + i + ", mass: " + mass + ", position: (" + xxPos + ", " + yyPos + "), velocity: (" + xxVel + ", " + yyVel + "), path: " + path);

		}
		System.out.println("Count: "+count+" radius: " + radius);

		// int firstItemInFile = in.readInt();
		// double secondItemInFile = in.readDouble();
		// String thirdItemInFile = in.readString();
		// String fourthItemInFile = in.readString();
		// double fifthItemInFile = in.readDouble();
		//
		// System.out.println("The file contained "  + firstItemInFile + ", " +
		// 	               secondItemInFile + ", " + thirdItemInFile + ", " +
		// 	               fourthItemInFile + ", and " + fifthItemInFile);
	}
} 