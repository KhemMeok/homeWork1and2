package PeopleService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.People;
import application.Pet;
import application.PetType;

public class ApplicationService {
	public static void showLine(String name) {
		System.out.println();
		System.out.println("========================================" + name + "==================================");
	}

	public static void showMinAgeOfPeople(People[] peoples) {
 	Stream<People> s = Stream.of(peoples);
//		Optional<Integer> min = s.map(a -> a.getAge()).min((x, y) -> x.compareTo(y));
//		List<String> name = new ArrayList<String>();
//
//		for (int i = 0; i < peoples.length; i++) {
//
//			if (peoples[i].getAge() == min.get()) {
//
//				name.add((peoples[i].getName() + "(" + peoples[i].getAge() + ")").toString());
//			}
//		}
//		System.out.println(name);
		 People people = s.min((a,b)->a.getAge()-b.getAge())
		 .get();		
		System.out.println(people.getName()+" "+people.getAge());
	}

	public static void showPeoPleNoPet(People[] peoples) {
		List<String> name = new ArrayList<String>();
		for (int i = 0; i < peoples.length; i++) {
			if (peoples[i].getPet().size() <= 0) {
				name.add(peoples[i].getName());
			}
		}
		System.out.println(name);
		
//		Stream<People> s = Stream.of(peoples);
//		boolean anyMatch = s.anyMatch(p->p.getPet().isEmpty());
		
	}

	public static void showMeleAndFemalePetCat(People[] peoples,String PetName) {
//		List<List<String>> list = new ArrayList<>();
//		// List<String> list2 = new ArrayList<>();
//		List<String> listMale = new ArrayList<>();
//		List<String> listFemale = new ArrayList<>();
//
//		int i = 0;
//		for (i = 0; i < peoples.length; i++) {
//			list.add(peoples[i].getPet().stream().map(a -> a.getName()).collect(Collectors.toList()));
//
//			if (peoples[i].getPet().stream().map(a -> a.getName()).collect(Collectors.toList()).contains("Cat")) {
//				if (peoples[i].getGender().equals("M")) {
//					listMale.add(peoples[i].getName());
//				} else {
//					listFemale.add(peoples[i].getName());
//				}
//			}
//		}
//
//		System.out.println("People Pet Cat Male are :" + listMale.size());
//		System.out.println(listMale);
//		System.out.println("People Pet Cat Female are :" + listFemale.size());
//		System.out.println(listFemale);
//		Stream<People> s3 = Stream.of(peoples);
// 		List<String> collect = s3.filter(b->b.getPet().equals(PetName)).map(c->c).collect(Collectors.groupingBy(b);
// 	 	System.out.println(collect);
	}

	public static void showPeoplePetsCat(People[] peoples,Object PetName) {
		 
//		List<String> list2 = new ArrayList<>();
//
//		int i = 0;
//		for (i = 0; i < peoples.length; i++) {
//			//list.add(peoples[i].getPet().stream().map(a -> a.getName()).collect(Collectors.toList()));
//
//			if (peoples[i].getPet().stream().map(a -> a.getName()).collect(Collectors.toList()).contains(cat)) {
//				list2.add(peoples[i].getName());
//			}
//		}
//
	 
 		Stream<People> s3 = Stream.of(peoples);
 	  List<String> collect = s3.filter(b->b.getPet().contains(PetName)).map(a->a.getName()).collect(Collectors.toList());
 	  System.out.println(collect);
 	 	 
	}
	public static void showPeoPleHasPetsMoreThanOne(People[] peoples, int min) {
//		List<String> name = new ArrayList<String>();
//		for (int i = 0; i < peoples.length; i++) {
//			if (peoples[i].getPet().size() > 1) {
//				name.add(peoples[i].getName()
//						+ peoples[i].getPet().stream().map(a -> a.getName()).collect(Collectors.toList()).toString());
//			}
//		}
//		System.out.println(name);
		Stream<People> s3 = Stream.of(peoples);
		List<String> collect = s3.filter(a -> a.getPet().size() > min).map(b -> b.getName())
				.collect(Collectors.toList());
		System.out.println(collect.toString());

	}

	public static void showPeopleMaleAndFemale(People[] people) {

//		Stream<People> s1 = Stream.of(people);
//		int countM = (int) s1.filter(a -> a.getGender().contains("M")).count();
//		System.out.println("Male :" + countM);
//		Stream<People> s2 = Stream.of(people);
//		int countF = (int) s2.filter(b -> b.getGender().contains("F")).count();
//		System.out.println("Female :" + countF);
		Stream<People> s3 = Stream.of(people);
		Map<String, Long> collect = s3.collect(Collectors.groupingBy(a -> a.getGender(), Collectors.counting()));

		System.out.println(collect);

	}
	
	public static void showTypeOfPet(People[] people ) {
		Stream<People> s3 = Stream.of(people);
		Map<Object, Long> collect = s3.distinct().collect(Collectors.groupingBy(a->a.getPet(),Collectors.counting()));
				
	 	System.out.println(collect);

	}
	public static void showGroupByAge(People[] people ) {
		Stream<People> s3 = Stream.of(people);
		Map<Object, Long> collect = s3.collect(Collectors.groupingBy(a->a.getAge(),Collectors.counting()));
				
	 	System.out.println(collect);

	}
	
	public static void showPeopleAgeUpper18andLower18(People[] people ) {
		Stream<People> s3 = Stream.of(people);
		List<String> collect = s3.filter(a->a.getAge()>18).map(a->a.getName()).collect(Collectors.toList());
	 	System.out.println("Can :"+collect);
	 	Stream<People> s4 = Stream.of(people);
		List<String> collect1 = s4.filter(a->a.getAge()<18).map(a->a.getName()).collect(Collectors.toList());
	 	System.out.println("Cannot :"+collect1);

	}
	public static void showPeopleNameByAge(People[] people ) {
//	
		Stream<People> s3 = Stream.of(people);
////		Function<People, Integer> Age = age->age.getAge();
//		 Map<List<PetType>, List<People>> collect;
//		  
//			//collect = s3.collect(Collectors.groupingBy(b->b.getPet(),Collectors.toList()));  Collectors.mapping(People::getName, Collectors.toList()
		//  s3.collect(Collectors.groupingBy(People::getAge),Collectors.toList());
//	 	//System.out.println(collect2);
//		List<People> l = List.of(people);
//		List<String> map = l.stream().map(a->a.getName()).collect(Collectors.toList());
//		System.out.println(map);
//	    Map<List<PetType>, Object> collect = s3.collect(Collectors.groupingBy(People::getPet,Collectors.collectingAndThen(Collectors.toList(),(l) ->{
//	    	Stream<People> s4 = Stream.of(people);
//	    	String string = s4.map(f->f.getName()).collect(Collectors.toList()).toString();
//    	return string;
//	    	
//	    	
//	    })));
//	 
//	        	  Stream<People> s4 = Stream.of(people);
//		    	String string = s4.map(f->f.getName()).collect(Collectors.toList()).toString();
//	    	return string;
//	 	  System.out.println(collect);
		
	 	    Map<List<PetType>, Object> collect = s3.collect(Collectors.groupingBy(People::getPet,Collectors.collectingAndThen(Collectors.toList(),list ->{
 		    	
	 	    	List<String> collect2 = list.stream().map(n->n.getName()).collect(Collectors.toList());
		    	return collect2;
		    	
		    })));
		 
		        	  
		 	  System.out.println(collect);
	}
	//&&f.getGender().equals("F")&&(f.getAge()>19&&f.getAge()<21)

	public static void showPeopleNameAndAgeHasCatNoDogFemaleAge19to21(People[] people ) {
		Stream<People> s3 = Stream.of(people);
		   List<String> collect = s3.filter(f->f.getGender().equals("F")&&f.getAge()>19&&f.getAge()<21&&f.getPet().contains(PetType.Cat)&&!(f.getPet().contains(PetType.Dog))).map(a->"Name :"+a.getName()+" Age :"+a.getAge()).collect(Collectors.toList());
		//  List<String> collect = s3.filter(f->!f.getPet().contains(PetType.Cat)).map(a->"Name :"+a.getName()+" Age :"+a.getAge()).collect(Collectors.toList());
	
	 	System.out.println(collect);

	}
}
