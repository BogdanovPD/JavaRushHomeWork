package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements Cloneable, Serializable, List<String>
{
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException
    {

        List<String> listTree = new Solution();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        listTree.remove("2");
        listTree.remove("9");
        listTree.add("16");
        listTree.add("17");
        listTree.add("18");
        listTree.add("19");
        listTree.add("20");

        listTree.remove("18");
        listTree.remove("20");

        listTree.add("21");
        listTree.add("22");
        listTree.add("23");

        System.out.println(listTree);

//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        List<String> list2222 = new Solution();
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        list2222.add("test");
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        List<String> list1111 = new Solution();
//        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());
//
        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
//        listTree.clear();
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//        System.out.println(listTree);
//
//        //For additional check correct work clone method
//        Solution list = ((Solution)listTree).clone();
//
//        System.out.println("Start value with using clone: " + listTree);
//        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
//        list.remove("2");
//        list.remove("9");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
//        list.add("16");
//        list.add("17");
//        list.add("18");
//        list.add("19");
//        list.add("20");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== REMOVE 18 and 20 =====");
//        list.remove("18");
//        list.remove("20");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== ADD 21 and 22 =====");
//        list.add("21");
//        list.add("22");
//        list.add("23");
//        list.add("24");
//        list.add("25");
//        list.add("26");
//        list.add("27");
//        list.add("28");
//        list.add("29");
//        list.add("30");
//        list.add("31");
//        list.add("32");
//        //list.add(null);
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n---------------------------------------");
//        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
//        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
//        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
//        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
//        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
//        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
//        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
//        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
//        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
//        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
//        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
//        System.out.println("--->> By task and add more item:");
//        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
//        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
//        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
//        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
//        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
//        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
//        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
//        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
//        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
//        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
//        System.out.println("---------------------------------------");
//        System.out.println("Size array = " + list.size() + " expected = 22");
//        System.out.println();
//
//        System.out.println("=============== Clone test ==================");
//
//        System.out.println("Object: " + list + " --> Size = " + list.size());
//        Solution sol = list.clone();
//        //list.remove("7"); //Select for test
//        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
//        System.out.println("Result: " + list.containsAll(sol));
//
//        System.out.println("\nTest addAll: ");
//        Solution add = new Solution();
//        add.addAll(sol);
//        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());
//
//        System.out.println("=============== Iterator test ===============");
//        Iterator<String> itr = list.iterator();
//        while (itr.hasNext()) {
//            String a = itr.next();
//            System.out.print(a + " ");
//        }
//        System.out.println("\nExpected size 22 = " + list.size());
//
//        System.out.println("\nIter remove");
//        Iterator<String> itr2 = list.iterator();
//        while (itr2.hasNext()) {
//            if (itr2.next().contains("31")) {
//                itr2.remove();
//            }
//        }
//        System.out.println("For test " + list + " --> Size = " + list.size());
//        System.out.println("Collect size " + list.size() + " Expected 21");
//
//        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
//        System.out.println("Collect before serializable " + list);
//        System.out.print("Save list");
//        FileOutputStream fos = new FileOutputStream("file");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
//        oos.close();
//        fos.close();
//        System.out.println(" Serializable done");
//        System.out.print("Load list");
//        FileInputStream fis = new FileInputStream("file");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        List<String> list2 = (List<String>) ois.readObject();
//        ois.close();
//        fis.close();
//        System.out.println(" Deserializable done");
//        System.out.println("Collect after deserializable " + list2);
//        System.out.println(list.equals(list2));
//
//        System.out.println("\n================ Clear test =================");
//        System.out.println("Before: " + listTree);
//        listTree.clear();
//        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));
    }

    //private static final long serialVersionUID = -2851667679971038690L;

    int size;
    private Node root;
    private boolean deletedLast = false;
    Solution thisInstance = this;

    LinkedList<Node> list = new LinkedList<Node>();

    public Solution() {
        root = new Node(null, null, null, null);
        list.add(root);
    }

    private Solution(Node root){
        this.root = root;
        list.add(root);
    }

    private static class Node implements Serializable{
        String item;
        Node right;
        Node left;
        Node parent;

        Node(Node left, String element, Node right, Node parent) {
            this.item = element;
            this.right = right;
            this.left = left;
            this.parent = parent;
        }

        @Override
        public String toString()
        {
            return this.item;
        }

    }

    @Override
    public boolean add(String el){
        int counter = 0;
        Node newNode = null;
        for (Node node:list)
        {
            if (!deletedLast){
            if (node.left == null)
            {
                newNode = new Node(null, el, null, node);
                node.left = newNode;
                list.add(node.left);
                size = list.size() - 1;
                return true;
            }
            else if (node.right == null){
                newNode = new Node(null, el, null, node);
                node.right = newNode;
                list.add(node.right);
                size++;
                return true;
            }
            }
            else {
                counter++;
                if (counter == list.size()){
                    newNode = new Node(null, el, null, node.parent);
                    node.parent.right = newNode;
                    list.add(node.parent.right);
                    size = list.size() - 1;
                    deletedLast = false;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object el){
        boolean removed = false;
        for (Node node:list){
            if (node.item != null)
            if (node.item.equals((String) el)){
                node.item = null;
                removed = true;
                break;
            }
        }
        if (removed){

            Iterator<Node> iterator = list.iterator();
            Node element = null;
            while (iterator.hasNext())
            {
                element = iterator.next();
                if (!element.equals(root))
                {
                    if (element.parent.item == null && !element.parent.equals(root))
                    {
                        element.item = null;
                    }
                }
            }


                iterator = list.iterator();

            int counter = 0;
                while (iterator.hasNext())
                {
                    counter++;
                    element = iterator.next();
                    if (!element.equals(root))
                    {
                        if (!element.equals(root) && element.item == null)
                        {
                            if (counter == list.size() && list.contains(element.parent)){
                                deletedLast = true;
                            }
                            iterator.remove();
                        }
                    }
                }
            size = list.size();
            return true;
        }
        return false;
    }

    public Node getParent(String item){
        for (Node node:list){
            if (node.item != null)
                if (node.item.equals(item))
                    return node.parent;
        }
        return null;
    }


    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

//    @Override
//    public void add(int index, String element)
//    {
//        throw new UnsupportedOperationException();
//    }
//

//    private Node find(Object o)
//    {
//        try
//        {
//            String el = (String)o;
//            for (Node node:list)
//            {
//                if (node.item != null)
//                    if (node.item.equals(el))
//                        return node;
//            }
//        }
//        catch (ClassCastException e){
//
//        }
//        return null;
//    }
//
//    @Override
//    public boolean contains(Object o)
//    {
//        return find(o) != null;
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> c)
//    {
//        for (Object o:c)
//        {
//            if (!contains(o))
//                return false;
//        }
//        return true;
//    }

//    @Override
//    public String remove(int index)
//    {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends String> c)
//    {
//        try
//        {
//            for (Object o:c)
//            {
//                add((String)o);
//            }
//        }
//        catch (ClassCastException e){
//            throw  new UnsupportedOperationException();
//        }
//        return true;
//    }

//    @Override
//    public boolean addAll(int index, Collection<? extends String> c)
//    {
//        throw new UnsupportedOperationException();
//    }



    @Override
    public int size()
    {
        return list.size()-1;
    }

    public Iterator<String> iterator(){
        return new Iterator<String>()
        {
            int i = 1;
            @Override
            public boolean hasNext()
            {
                return i < size() + 1;
            }

            @Override
            public String next()
            {
                String item = list.get(i).item;
                i++;
                return item;
            }

            @Override
            public void remove()
            {
                Node tempNode = list.get(i - 1);
                thisInstance.remove(list.get(i).item);
                i = 0;
                for (Node node:list)
                {
                    i++;
                    if (node.equals(tempNode))
                        break;
                }
                i++;
            }
        };
    }

//    private void writeObject(ObjectOutputStream o) throws IOException
//    {
//        o.defaultWriteObject();
//        o.writeInt(list.size());
//        for (Node el:list)
//        {
//            o.writeObject(el);
//        }
//    }
//
//    private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException
//    {
//        o.defaultReadObject();
//        int len = o.readInt();
//        list.clear();
//
//        for (int i = 1; i <= len; i++)
//        {
//            list.add((Node)o.readObject());
//        }
//    }

//    @Override
//    public String set(int index, String element)
//    {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public int indexOf(Object o)
//    {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public int lastIndexOf(Object o)
//    {
//        throw new UnsupportedOperationException();
//    }

    @Override
    public void clear()
    {
        list.clear();
        root = new Node(null, null, null, null);
        list.add(root);
    }

//    @Override
//    public boolean isEmpty()
//    {
//        return list.size() == 1;
//    }

//    @Override
//    public Solution clone() throws CloneNotSupportedException
//    {
//        Solution res = new Solution(list.get(0));
//        for (Node el:list)
//        {
//            if (el.equals(root))
//                continue;
//
//            res.list.add(el);
//        }
//        return res;
//    }

//    @Override
//    public ListIterator<String> listIterator(int index)
//    {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = super.hashCode();
//        result = 31 * result + root.hashCode();
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object o)
//    {
//        try
//        {
//            Solution sl = (Solution)o;
//            if (sl.size() != this.size())
//                return false;
//            for (int i = 1; i < size(); i++)
//            {
//                if (!this.list.get(i).item.equals(sl.list.get(i).item))
//                    return false;
//            }
//        }
//        catch (ClassCastException e){
//            return false;
//        }
//        return true;
//    }

//    @Override
//    protected void removeRange(int fromIndex, int toIndex)
//    {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public List<String> subList(int fromIndex, int toIndex)
//    {
//        throw new UnsupportedOperationException();
//    }

}
