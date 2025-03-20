
import edu.princeton.cs.algs4.*;
public class Triangle {
    public static void main(String[] args) {
        // 设置绘图坐标范围
        StdDraw.setScale(-0.05, 1.05);
        
        // 计算等边三角形的高度
        double t = Math.sqrt(3.0) / 2.0;

        // 画三角形的三条边
        StdDraw.line(0.0, 0.0, 1.0, 0.0);  // 底边
        StdDraw.line(1.0, 0.0, 0.5, t);    // 右边
        StdDraw.line(0.5, t, 0.0, 0.0);    // 左边

        // 设置画笔粗细
        StdDraw.setPenRadius(0.01);

        // 画三角形的三个顶点（标记点）
        StdDraw.point(0.0, 0.0);
        StdDraw.point(1.0, 0.0);
        StdDraw.point(0.5, t);
    }
}
