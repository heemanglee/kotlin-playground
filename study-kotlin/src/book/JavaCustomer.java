package book;

class JavaCustomer {

    public static void main(String[] args) {

        // 코틀린에서 변수에 const를 붙여 상수 처리를 해주아야 자베에서 접근할 수 있다.
        System.out.println(KotlinCustomer.NAME); // KotlinCustomer

        // @JvmStatic을 사용한 경우 Companion을 생략할 수 있다.
        KotlinCustomer.call(); // name = KotlinCustomer

        // @JvmStatic을 사용하지 않는 경우 Companion을 포함해서 호출한다.
        KotlinCustomer.Companion.call(); // ame = KotlinCustomer

        KotlinCustomer.name = "asd"; // aa -> asd
        System.out.println(KotlinCustomer.name); // asd
    }
}
