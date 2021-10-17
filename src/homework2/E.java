package homework2;
import java.util.*;
public class E {
    private static class Point {
        int x = 0;
        int y = 0;
    }
    public static int  N = 100005;
    public  static double getDis(Point ri, Point le) {
        return Math.sqrt((ri.x - le.x)*(ri.x - le.x) + (ri.y - le.y)*(ri.y - le.y));
    }
    public static double divide(int left, int right, Point[] points)
    {
        // 当前最小两点距离，初始值设置为无穷大
        double curMinDis = Double.MAX_VALUE;
        // 如果只有一个点，则不存在最近两点距离，返回无穷大
        if (left == right)
        {
            return curMinDis;
        }
        // 这里是判断是否为只有两个点，如果只有两个点的话那么直接求解。
        if (left + 1 == right)
        {
            return getDis(points[left], points[right]);
        }

        // 分治法：第一步：分区，并求取左右分区最小两点距离
        int middle = (left + right) >> 1;
        double leftMinDis = divide(left, middle, points);
        double rightMinDis = divide(middle+1, right, points);
        curMinDis = Math.min(leftMinDis,rightMinDis);
        // 分治法：第二步：假设距离最近的两点分别在左右分区中
        List<Point> validPointIndex = new ArrayList<>();
        for (int i = left; i <= right; i++)
        {
            if (Math.abs(points[middle].x - points[i].x) <= curMinDis)
            {
                validPointIndex.add(points[i]);
            }
        }
        //按照y排序
        Collections.sort(validPointIndex,new Comparator<Point>()
        {
            @Override
            public int compare(Point p1, Point p2)
            {
                return (p1.y > p2.y) ? 1 : (p1.y == p2.y) ? 0 : -1;
            }
        });
        // 基于索引，进一步计算区间内最小两点距离
        for (int i = 0; i < validPointIndex.size() - 1; i++)
        {
            for (int j = i + 1; j < validPointIndex.size(); j++)
            {
                if (Math.abs(validPointIndex.get(i).y - validPointIndex.get(j).y) >= curMinDis )
                {
                    break;
                }
                curMinDis = Math.min(curMinDis,getDis(validPointIndex.get(i), validPointIndex.get(j)));
            }
        }
        return curMinDis;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; ++i) {
                Point p = new Point();
                p.x = in.nextInt();
                p.y = in.nextInt();
                points[i] = p;
            }
            //根据x轴排序
            Arrays.sort(points, new Comparator<Point>()
            {
                @Override
                public int compare(Point p1, Point p2)
                {
                    return (p1.x > p2.x) ? 1 : (p1.x == p2.x) ? 0 : -1;
                }
            });
            double res = divide(0,n-1,points);
            System.out.printf("%.0f",res*res);
        }

        in.close();
    }
}
