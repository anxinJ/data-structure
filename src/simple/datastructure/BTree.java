package simple.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * B- 树
 * 是一种多路搜索树（并不是二叉的）：
 * 1. 定义任意非叶子结点最多只有 M 个儿 子；且 M>2 ；
 * 2. 根结点的儿子数为 [2, M] ；
 * 3. 除根结点以外的非叶子结点的儿子数为 [M/2, M] ；
 * 4. 每个结点存放至少 M/2-1 （取 上整）和至多 M-1 个关键字；（至少 2 个关键 字）
 * 5. 非叶子结点的关键字个数 = 指向儿 子的指针个数 -1 ；
 * 6. 非叶子结点的关键字： K[1], K[2], …, K[M-1] ；且 K[i] < K[i+1] ；
 * 7. 非叶子结点的指针： P[1], P[2], …, P[M] ；其中 P[1] 指向关键字小于 K[1] 的子树， P[M] 指向关键字大于 K[M-1] 的子树，其它 P[i] 指 向关键字属于 (K[i-1], K[i]) 的子树；
 * 8. 所有叶子结点位于同一层；
 * <p>
 * Created by hewj on 17/8/17.
 */
public class BTree<T extends Comparable> {

    private BTreeNode<T> root;
    int m;// 阶
    int n;// 非叶子节点最少儿子数(根节点除外)
    public static final int ROOT_MIN_KEYS = 2;// 根节点最少儿子数

    public void insert(T data){
        if(root == null){
            root = new BTreeNode<>(data);
        }
    }

    public T delete(T data){
        return null;
    }

    public BTreeNode find(T data){
        return null;
    }

    public String toString(){
        return null;
    }




    class BTreeNode<T> {
        BTreeNode parent;
        List<T> datas = new ArrayList<>();
        List<BTreeNode> keys = new ArrayList<>();

        public BTreeNode(T data){
            datas.add(data);
        }

    }
}
