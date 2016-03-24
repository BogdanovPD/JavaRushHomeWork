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
//        System.out.println(listTree.size());
//        for (String list:listTree)
//        {
//            System.out.print(list + " ");
//        }
        listTree.add("17");
        listTree.add("18");
        listTree.add("19");
        listTree.add("20");

        listTree.remove("18");
        listTree.remove("20");

        listTree.add("21");
        listTree.add("22");
        System.out.println();
        for (String list:listTree)
        {
            System.out.print(list + " ");
        }
        System.out.println();
        System.out.println(listTree.size());
        listTree.add("23");

        listTree.remove("1");

        listTree.add("24");

        System.out.println(listTree);

        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("1"));
        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        //For additional check correct work clone method
        Solution list = ((Solution)listTree).clone();

        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 21 and 22 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        //list.add(null);
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        Solution sol = list.clone();
        //list.remove("7"); //Select for test
        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        Solution add = new Solution();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);
        System.out.println(list.equals(list2));

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);

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
        listTree.add("24");
        listTree.add("25");
        listTree.add("26");
        listTree.add("27");
        listTree.add("28");
        listTree.add("29");
        listTree.add("30");
        listTree.add("31");
        listTree.add("32");

        itr2 = listTree.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }

        Solution clList = ((Solution)listTree).clone();

        listTree.remove("29");
        clList.remove("29");

        System.out.println(listTree.equals(clList));
        System.out.println(listTree);
        System.out.println(listTree.remove("500"));
        System.out.println(listTree);
        System.out.println(listTree.equals(clList));

        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));
    }

    private int size = 0;
    private LinkedList<LinkedList<Node>> list = new LinkedList<LinkedList<Node>>();
    private int currentId = 0;
    private int currentLvl = 0;
    private int currentIndex = 0;
    private boolean deletedLast = false;
    private Solution solution = this;
    private static final long serialVersionUID = 876323262645176354L;

    private class Node implements Serializable{
        String item;
        Node right;
        Node left;
        Node parent;
        int id;
        int lvl;

        Node(Node left, String element, Node right, Node parent) {
            this.item = element;
            this.right = right;
            this.left = left;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object obj)
        {
            try
            {
                Node node = (Node)obj;
                boolean id = (node.id == this.id);
                boolean lvl = (node.lvl == this.lvl);
                boolean item = solution.checkItem(this, node);

                return id && lvl && item;
            }
            catch (ClassCastException e){
                return false;
            }
        }

        @Override
        public String toString()
        {
            return this.item;
        }

    }

    @Override
    public boolean add(String el){
        if (currentLvl == 0){
            list.add(new LinkedList<Node>());
            list.get(0).add(new Node(null, null, null, null));
            currentId++;
        }
        checkEmpties();
        newLine();
        LinkedList<Node> currentList = list.get(currentLvl);
        if (size >= 1)
        currentId++;
        currentIndex++;
        Node newNode;
        Node element;
        if (currentLvl == 1){
            element = list.get(0).get(0);
            newNode = new Node(null, el, null, element);
        }
        else
        {
            int elementPosition = getParentElementPosition();

            while (list.get(currentLvl - 1).get(elementPosition).item == null){
                currentList.add(new Node(null, null, null, null));
                currentList.add(new Node(null, null, null, null));
                currentIndex+=2;
                elementPosition++;
                if (elementPosition == list.get(currentLvl - 1).size()){
                    newLine();
                    elementPosition = 0;
                    currentList = list.get(currentLvl);
                    currentIndex++;
                }
            }
            element = list.get(currentLvl - 1).get(elementPosition);
            newNode = new Node(null, el, null, element);
        }
        newNode.id = currentId;
        newNode.lvl = currentLvl;
        if (currentId%2 == 0){
            newNode.parent.right = newNode;
        }
        else
            newNode.parent.left = newNode;

        if (deletedLast)
        {
            list.get(currentLvl).set(list.get(currentLvl).size() - 1, newNode);
            deletedLast = false;
        }
        else
        currentList.add(newNode);

        size++;

        return true;
    }

    @Override
    public boolean remove(Object el){
        try
        {
            String soughtFor = (String)el;
            return removeStr(soughtFor);
        }
        catch (ClassCastException e){
            try
            {
                Node soughtFor = (Node)el;
                return removeNode(soughtFor);
            }
            catch (ClassCastException e1){
                return false;
            }
        }
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o)
    {
        return find(o) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        for (Object o:c)
        {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public String remove(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends String> c)
    {
        try
        {
            for (Object o:c)
            {
                add((String)o);
            }
        }
        catch (ClassCastException e){
            throw  new UnsupportedOperationException();
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public String set(int index, String element)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear()
    {
        size = 0;
        list = new LinkedList<LinkedList<Node>>();
        currentId = 0;
        currentLvl = 0;
        currentIndex = 0;
    }

    @Override
    public boolean isEmpty()
    {
        return list.size() == 0;
    }

    @Override
    public Solution clone() throws CloneNotSupportedException
    {
        Solution res = new Solution();
        for (LinkedList<Node> el:list)
        {
            LinkedList<Node> newList = new LinkedList<Node>();
            res.list.add(newList);
            for (Node el1:el)
            {
                Node newNode = new Node(null, el1.item, null, null);
                newNode.id = el1.id;
                newNode.lvl = el1.lvl;
                newList.add(newNode);
            }

        }

        for (int i = 1; i < list.size(); i++)
        {
            for (int j = 0; j < list.get(i).size(); j++)
            {
                if (list.get(i).size() == 2)
                    res.list.get(i).get(j).parent = res.list.get(0).get(0);
                else {
                    if (list.get(i).get(j).parent != null)
                        res.list.get(i).get(j).parent = res.getElementById(list.get(i).get(j).parent.id);
                    if (list.get(i).get(j).left != null)
                        res.list.get(i).get(j).left = res.getElementById(list.get(i).get(j).left.id);
                    if (list.get(i).get(j).right != null)
                        res.list.get(i).get(j).right = res.getElementById(list.get(i).get(j).right.id);
                }
            }
        }

        res.size = size();
        res.currentLvl = currentLvl;
        res.currentIndex = currentIndex;
        res.currentId = currentId;
        return res;
    }


    @Override
    public ListIterator<String> listIterator(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + list.get(0).get(0).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        try
        {
            Solution sl = (Solution)o;
            if (sl.size() != this.size())
                return false;
            else {

                for (int i = 0; i < list.size(); i++)
                {
                    for (int j = 0; j < list.get(i).size(); j++)
                    {
                        return list.get(i).get(j).equals(sl.list.get(i).get(j));
                    }
                }
            }
        }
        catch (ClassCastException e){
            return false;
        }
        return false;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Iterator<String>()
        {
            int i = 1;
            int j = 0;
            int counter = 0;
            @Override
            public boolean hasNext()
            {
                return counter != size();
            }

            @Override
            public String next()
            {
                while (true){
                    if (j==list.get(i).size()){
                        i++;
                        j = 0;
                    }
                    if (list.get(i).get(j).item == null){
                        j++;
                    }
                    else
                        break;
                }
                counter++;
                return list.get(i).get(j++).item;
            }

            @Override
            public void remove()
            {
                removeNode(list.get(i).get(j-1));
            }
        };
    }

    private void writeObject(ObjectOutputStream o) throws IOException
    {
        o.defaultWriteObject();
        o.writeInt(list.size());
        for (LinkedList<Node> el:list)
        {
            o.writeObject(el);
        }
    }

    private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException
    {
        o.defaultReadObject();
        int len = o.readInt();
        list.clear();

        for (int i = 0; i < len; i++)
        {
            list.add((LinkedList<Node>) o.readObject());
        }
    }

    private Node getElementById(int elementId)
    {
        for (LinkedList<Node> el:list)
        {
            for (Node el1:el)
            {
                if (el1.id != 0)
                    if (el1.id == elementId)
                        return el1;
            }
        }
        return null;
    }

    private Node find(Object o)
    {
        try
        {
            for (LinkedList<Node> l:list)
            {
                for (Node l2:l)
                {
                    if (l2.item != null)
                        if (l2.item.equals((String)o))
                            return l2;
                }
            }
        }
        catch (ClassCastException e){
            return null;
        }
        return null;
    }

    private boolean checkItem(Node node1, Node node2){
        boolean item = false;
        if (node1.item == null & node2.item == null)
            item = true;
        if (node1.item != null & node2.item != null)
            if (node1.item.equals(node2.item))
                item = true;
            else
                item = false;
        return item;
    }

    private boolean removeStr(String soughtFor){
        boolean removed = false;
        ArrayList<Node> deleted = new ArrayList<Node>();
        for (LinkedList<Node>l1:list)
        {
            for (Node l2:l1)
            {
                if (l2.item != null)
                    if (l2.item.equals(soughtFor))
                    {
                        toNull(deleted, l2);
                        removed = true;
                    }
            }
        }
        if (removed)
        {
            removeChildren(deleted);
            return removed;
        }
        return false;

    }

    private void toNull(ArrayList<Node> deleted, Node l2)
    {
        l2.item = null;
        size--;
        deleted.add(l2);
        if (l2.id == currentId){
            currentId--;
            currentIndex--;
            deletedLast = true;
        }
    }

    private boolean removeNode(Node el){
        boolean removed = false;
        ArrayList<Node> deleted = new ArrayList<Node>();
        for (LinkedList<Node>l1:list)
        {
            for (Node l2:l1)
            {
                if (l2.item != null)
                    if (l2.equals(el))
                    {
                        toNull(deleted, l2);
                        removed = true;
                    }
            }
        }

        if (removed)
        {
            removeChildren(deleted);
            return removed;
        }
        return false;

    }

    public void removeChildren(ArrayList<Node> deleted){
        int c = 0;
        for (LinkedList<Node>l1:list)
        {
            c++;
            if (c > 2)
                for (Node l2:l1)
                {
                    if (l2.item != null)
                        if (deleted.contains(l2.parent))
                        {
                            l2.item = null;
                            size--;
                            deleted.add(l2);
                        }
                }
        }
    }

    public String getParent(String item){

        for (LinkedList<Node> l:list)
        {
            for (Node l1:l)
            {
                if (l1.item != null)
                    if (l1.item.equals(item))
                        return l1.parent.item;
            }
        }
        return null;
    }

    private int getParentElementPosition()
    {
        return currentIndex % 2 == 0 ?
                (currentIndex / 2) - 1
                : (((currentIndex + 1) / 2) - 1);
    }

    private void newLine()
    {
        if ((double)list.get(currentLvl).size() == Math.pow(2.0, currentLvl))
        {
            list.add(new LinkedList<Node>());
            currentLvl++;
            currentIndex = 0;
        }
    }

    private void checkEmpties(){
        int lastEmpty = 0;
        int lastCurrentId = 0;
        int lastCurrentLvl = 0;
        for (int i = list.size() - 1; i > 0 ; i--)
        {
            boolean anyoneEmpty = true;
            for (int j = list.get(i).size() - 1; j >= 0 ; j--)
            {
                if (list.get(i).get(j).item != null)
                    anyoneEmpty = false;
                else{
                    lastCurrentId = list.get(i).get(j).id;
                    lastCurrentLvl = list.get(i).get(j).lvl;
                }
            }
            if (anyoneEmpty)
            {
                lastEmpty = i;
                currentId = lastCurrentId -1;
                currentIndex = list.get(currentLvl - 1).size() - 1;
                currentLvl = lastCurrentLvl - 1;
            }
        }

        if (lastEmpty != 0){
            LinkedList<LinkedList<Node>> newList = new LinkedList<LinkedList<Node>>();
            for (int i = 0; i < lastEmpty; i++)
            {
                newList.add(list.get(i));
            }
            list = newList;
        }
    }


}
