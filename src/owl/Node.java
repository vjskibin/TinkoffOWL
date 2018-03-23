package owl;

public class Node {
    private Integer data;
    private Node nextNodeLink;

    public Node()
    {
        data = null;
        nextNodeLink = null;
    }

    public Node(Integer data, Node nextNodeLink)
    {
        this.data = data;
        this.nextNodeLink = nextNodeLink;
    }

    public Node(Integer data)
    {
        this.data = data;
        this.nextNodeLink = null;
    }

    public Node getNext()
    {
        return this.nextNodeLink;
    }

    public void setNextElementLink(Node nextNodeLink) {
        this.nextNodeLink = nextNodeLink;
    }

    public Integer getData()
    {
        return this.data;
    }

    public void setData(Integer data)
    {
        this.data = data;
    }


}
