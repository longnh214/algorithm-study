abstract class Animal (
        protected val species: String, // 생성자
        open protected val legCount: Int, //하위 클래스에서 getter를 상속받아서 사용하려면 open 키워드를 적어야한다. (penguin)
){
    abstract fun move() //추상 메소드.
}