package lesson4.network;

import java.util.ArrayList;

public class Network {
    public class Member{
        private String name;
        private ArrayList<Member> friends;

        public Member(String name){
            this.name = name;
            this.friends = new ArrayList<>();
        }
        public void leave(){
            unenroll(this);
        }

        public boolean belongTo(Network n){
            return Network.this == n;
        }
    }
    //Network----------------------------------------------------------------
    private ArrayList<Member> members = new ArrayList<>();
    //this == new Network() == net1 ==newMember.outer
    public Member enroll(String name){
        Member newMember = this.new Member(name);
        members.add(newMember);
        return newMember;
    }
    public void unenroll(Member member){
        members.remove(member);
    }
}
