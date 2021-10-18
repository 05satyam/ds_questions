package graph;

import java.util.*;


class ListObj{
    public String item1;
    public String item2;
    public String item3;

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }
ListObj(){}
    public ListObj(String item1, String item2, String item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }
}

public class newtest {
    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter,
                                                   int sortOrder1, int itemsPerPage, int pageNumber) {
            // Write your code here
        List<ListObj> objList = new ArrayList<>();
        for(int i=0;i<items.size();i++){
            List aa = items.get(i);
            ListObj newObj  = new ListObj(String.valueOf(aa.get(0)),String.valueOf(aa.get(1)),String.valueOf(aa.get(2)));
            objList.add(newObj);
        }

            final int sortOrder  = sortOrder1;
            if(sortParameter==0){
                Collections.sort(objList, new Comparator<ListObj>() {
                    @Override
                    public int compare(ListObj p1, ListObj p2) {
                        int compare1=p1.getItem1().compareTo(p2.getItem1());
                        if(sortOrder==0){
                            return p1.getItem1().compareTo(p2.getItem1());
                        }else{
                           return  p2.getItem1().compareTo(p1.getItem1());
                        }
                    }
                });
            }
        if(sortParameter==1){
            Collections.sort(objList, new Comparator<ListObj>() {
                @Override
                public int compare(ListObj p1, ListObj p2) {
                   // int compare1=Integer.valueOf(p1.getItem2()) - Integer.valueOf(p2.getItem2());
                    if(sortOrder==0){
                        return Integer.valueOf(p1.getItem2()) - Integer.valueOf(p2.getItem2());
                    }else{
                       return  Integer.valueOf(p2.getItem2()) - Integer.valueOf(p1.getItem2());
                    }

                }
            });
        }

        if(sortParameter==2){
            Collections.sort(objList, new Comparator<ListObj>() {
                @Override
                public int compare(ListObj p1, ListObj p2) {
                    if(sortOrder==0){
                        return Integer.valueOf(p1.getItem3()) - Integer.valueOf(p2.getItem3());
                    }else{
                        return Integer.valueOf(p2.getItem3()) - Integer.valueOf(p1.getItem3());
                    }
                }
            });
        }

        List<List<String>> res = new ArrayList<>();
        int pageSizeCanB  = (objList.size()/itemsPerPage);
       int k=0;
        List<String> temp = new ArrayList<>();
        for(int m=0;m<objList.size();m++){
            if(k<pageSizeCanB){
             temp.add(objList.get(m).getItem1());
                k++;
            }else{
                k=0;
                res.add(temp);
                temp = new ArrayList<>();
            }
        }

        return res.get(pageNumber);
    }

    public static void main(String a[]){

    }
}
