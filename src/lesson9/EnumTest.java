package lesson9;

public class EnumTest {
    public static class Tshirts {
        private final Size size;

        public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};

        public Tshirts(Size $size){
            final Size size = $size;
            this.size = size;
        }
        public boolean isFit(Person target){
            final int base = target.height/2;
            switch(this.size){
                case SMALL:return base<50;
                case MEDIUM:return base<70;
            }

        }
    }
}
