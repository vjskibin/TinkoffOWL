package owl;

import java.util.ArrayList;

public class Main {

    public static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.getData()+"->");
            node = node.getNext();
        }
    }

    public static Node sumLists(ArrayList<Node> toSum)
    {
        Node summedHead = new Node();
        Node resultHead = summedHead;
        Node lastSumLink = toSum.get(toSum.size() - 1);
        //printList(lastSumLink);

        int maxCounter = 0;
        int currentCounter = 0;
        while(lastSumLink != null)
        {
            currentCounter++;
            lastSumLink = lastSumLink.getNext();
        }
        maxCounter = currentCounter;
        lastSumLink = toSum.get(toSum.size() - 1);

        Node sumLink;
        for(int i = 0; i < toSum.size(); i++)
        {
            sumLink = toSum.get(i);
            currentCounter = 1;
            while(sumLink.getNext() != null)
            {
                currentCounter++;
                sumLink = sumLink.getNext();
            }

            for(int j = currentCounter; j < maxCounter; j++)
            {
                //sumLink = new Node(0);
                sumLink.setNextElementLink(new Node(0));

               /* System.out.println("SUCCESFULLY ADDED! NOW ITS: ");
                Node check = toSum.get(i);
                while (check != null)
                {
                    System.out.print(check.getData()+"->");
                    check = check.getNext();
                }*/

                sumLink = sumLink.getNext();
            }

        }

        //toSum.set();

       /* sumLink = lastSumLink;
        System.out.println("!!!");
        while (sumLink != null)
        {
            System.out.print(sumLink.getData()+"->");
            sumLink = sumLink.getNext();
        }*/

        int remain = 0;
        while(lastSumLink != null)
        {
            int rowSum = 0;
            for(int i = 0; i < toSum.size(); i++)
            {
                rowSum += toSum.get(i).getData();
                System.out.println(toSum.get(i).getData()+"+");
                toSum.set(i,toSum.get(i).getNext());
            }
            //summedHead = new Node();
            summedHead.setData((rowSum + remain) % 10);
            summedHead.setNextElementLink(new Node()); //ТОЛДЬКО ТУТ ОСТАЛОСЬ ВОТ-ВОТ!!!!
            System.out.println("SUM: "+(rowSum + remain) % 10);
            remain = (rowSum + remain) / 10;
            System.out.println("REM: "+(rowSum + remain) / 10);


            summedHead = summedHead.getNext();
            lastSumLink = lastSumLink.getNext();
        }//
        while (remain != 0)
        {
            summedHead.setData(remain % 10);
            remain /= 10;
            summedHead = summedHead.getNext();
            summedHead.setNextElementLink(new Node());
        }

        return resultHead;
    }


    public static void main(String[] args) {
        Node headNodeFirst = new Node(7, new Node(1, new Node(6, new Node(2))));
        Node headNodeSecond = new Node(5, new Node(9, new Node(2)));

        int lengthFirst = 0, lengthSecond = 0;

        Node nodeFirst = headNodeFirst;
        Node nodeSecond = headNodeSecond;

        ArrayList<Node> toSum= new ArrayList<Node>();

        int sumsCounter = 0;
        int i = 0;

        while (nodeSecond != null) {

            nodeFirst = headNodeFirst; //set On Start
            int remain = 0; //1st digit goes to remain

            Node sumTemp = new Node();
            Node headSum = new Node();
            headSum = sumTemp;

            for(i = 0; i < sumsCounter; i++)
            {
                sumTemp.setData(0);
                sumTemp.setNextElementLink(new Node());
                sumTemp = sumTemp.getNext();
            }
            sumTemp.setData((nodeSecond.getData() * nodeFirst.getData() + remain) % 10);

            //Node sumTemp = new Node((nodeSecond.getData() * nodeFirst.getData() + remain) % 10); //last digit
            System.out.println("1st num: " + sumTemp.getData()); //log

            remain = (nodeSecond.getData() * nodeFirst.getData() + remain) / 10;
            System.out.println("1st remain: " + remain); //log
            nodeFirst = nodeFirst.getNext();
            while (nodeFirst.getNext() != null) {
                sumTemp.setNextElementLink(new Node((nodeSecond.getData() * nodeFirst.getData() + remain) % 10));
                System.out.println("Num: " + sumTemp.getNext().getData());
                remain = (nodeSecond.getData() * nodeFirst.getData() + remain) / 10;
                System.out.println("Remain: " + remain);

                nodeFirst = nodeFirst.getNext();
                sumTemp = sumTemp.getNext();

            }
            sumTemp.setNextElementLink(new Node((nodeSecond.getData() * nodeFirst.getData() + remain) % 10));
            System.out.println("Num: " + sumTemp.getNext().getData());
            remain = (nodeSecond.getData() * nodeFirst.getData() + remain) / 10;
            System.out.println("Remain: " + remain);
            if (remain != 0) {
                sumTemp = sumTemp.getNext();
                sumTemp.setNextElementLink(new Node(remain));
            }

            toSum.add(headSum);
            sumsCounter++;
            nodeSecond = nodeSecond.getNext();


        }

        Node result = sumLists(toSum);

        System.out.print(result.getData());
        result = result.getNext();

        while (result.getNext() != null && result != null)
        {
            System.out.print("->"+result.getData());
            result = result.getNext();
        }



        //USELESS
        /* (nodeFirst != null)
        {
            lengthFirst++;
            nodeFirst = nodeFirst.getNext();
        }


        //GARBAGE
        Node node = head;
        do {
            System.out.print(node.getData()+" ");
            node = node.getNext();
        } while (node != null);*/
    }
}
