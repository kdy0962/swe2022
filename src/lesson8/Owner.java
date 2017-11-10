package lesson8;

class Owner {
    private final int ownerValue;
    private final Base ownerBase;

    Owner(int ownerValue, Base ownerBase) {
        this.ownerValue = ownerValue;
        this.ownerBase = ownerBase;
    }

    @Override
    protected Owner clone() throws CloneNotSupportedException {
        //얕은 복사
        Owner result = new Owner(this.ownerValue, this.ownerBase);
        //깊은 복사
        result = new Owner(this.ownerValue, this.ownerBase.clone());
        return result;
    }
    public Base getBase(){
        return this.ownerBase;
    }
}
