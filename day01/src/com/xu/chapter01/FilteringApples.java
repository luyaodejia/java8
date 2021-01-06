package com.xu.chapter01;

/**
 * @author xudenghui
 * @create 2020-12-11 21:24
 **/
public class FilteringApples {

    public interface ApplePredicate{
        boolean test(Apple apple);
    }




    public static class Apple {
        private int weight = 0;
        private String color = "";
        public Apple(){

        }
        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

  public static void main(String[] args) {
      Apple apple = new Apple();
      if (apple!=null){
          System.out.println(apple);
      }
      System.out.println("33");
  }
}
