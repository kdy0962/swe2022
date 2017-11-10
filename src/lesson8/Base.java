package lesson8;

class Base {
    int baseValue;

    public Base(int baseValue){
        this.baseValue = baseValue;
    }

    @Override
    protected Base clone() throws CloneNotSupportedException {
        return new Base(this.baseValue);
    }

    @Override
    public String toString() {
        return "base : "+ this.hashCode()+":value = "+this.baseValue;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof Base)) return false;
        if(o.hashCode() == this.hashCode()) return true;
        return this.baseValue == ((Base)o).baseValue;
    }

}
