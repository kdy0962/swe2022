package lesson4;

import lesson4.network.Network;
import lesson4.network.Network2;

public class NetworkTest {
    static public void main(String[] arg){
        Network net1 = new Network();
        Network net2 = new Network();
        Network.Member fred =net1.enroll("fred");

        System.out.println(fred.belongTo(net2));
        Network.Member jane = net1.new Member("jane");
        Network.Member tom = net1.new Member("tom");

        Network2 n1 = new Network2();
        Network2 n2 = new Network2();
        Network2.Member a = n1.enroll("a");
        a.leave();
        Network2.Member b = new Network2.Member(n1, "b");
        Network2.Member c = new Network2.Member(n1, "c");
    }
}
