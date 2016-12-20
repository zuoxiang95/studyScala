package ScalaCookBook.TraitExample

/**
	* Created by hp on 2016/12/18.
	* 限制一个特质仅可以被哪些类使用，限制特质的使用范围
	*/

//example: 一个拥有合作商与很多零售商的大型连锁pizza店中，要求给客户送pizza的必须是零售商的员工，而不可以是合作商的员工

//pizza雇主类
abstract class Employee
//合作商类
class CorporateEmployee extends Employee
//零售商类
class StoreEmployee extends Employee

trait DeliversFood extends StoreEmployee
//传递食物类，继承自一个类与一个特质，且特质被混入到这个类中，他们有共同的超类
class DeliversPerson extends StoreEmployee with DeliversFood

//编译无法通过，因为CorporateEmployee和DeliversFood没有共同的超类
//class Receptionist extends CorporateEmployee with DeliversFood
