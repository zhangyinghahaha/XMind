package unit1.module5;

import util.StdIn;
import util.StdOut;

public class UF {
    // 分量id(以触电作为索引)
    private int[] id;
    // 分量数量
    private int count;

    public UF(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 在p和q之间添加一条连接
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        this.quickFind(p, q);
    }

    public void quickFind(int p, int q) {
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        // 归并后，分量数量减一
        count--;
    }

    public void quickUnion(int p, int q) {
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    /**
     * P所在的分量的标识符
     * @param p
     * @return
     */
    public int find(int p) {
        return this.id[p];
    }

    public int find2(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * p与q是否在同一个分量中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 连通分量的数量
     * @return
     */
    public int count() {
        return this.count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println(uf.id);
    }
}
