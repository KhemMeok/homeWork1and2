package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import PeopleService.ApplicationService;

public class Application {
	private static final String Cat = "Cat";

	/*
	 
	 * លំហាត់ទី១

ក្នុងភូមិមួយមានមនុស្ស១០នាក់។ ពួកគេមានសត្វចិញ្ចឹមតាមចំណូលចិត្តរៀងខ្លួន អ្នកខ្លះចិញ្ចឹមឆ្មា អ្នកខ្លះចិញ្ចឹមសុនក ឯអ្នកខ្លះទៀតចិញ្ចឹមសត្វច្រើនប្រភេទ។
ចូរបង្កើត Data Model និង Object ផ្សេងៗដែលបានរៀបរាប់ខាងលើ។
តាមទិន្នន័យដែលអ្នកបានបង្កើត៖
>> រាប់ចំនួនមនុស្សប្រុសនិងមនុស្សស្រី
>> តើអ្នកណាខ្លះចិញ្ចឹមសត្វលើសពី១ប្រភេទ?
>> អ្នកណាខ្លះចិញ្ចឹមឆ្មា?
>> តើប្រុសឬស្រីដែលចូលចិត្តចិញ្ចឹមឆ្មាជាងគេ?
>> តើមានអ្នកដែលអត់ចិញ្ចឹមសត្វដែរឬទេ
>> មនុស្សដែលមានអាយុតិចជាងគេឈ្មោះអ្វី?

រយៈពេលធ្វើ ៤ថ្ងៃ
	 * 
	 * 
	 * លំហាត់ទី២ (តពីទី១)

>> តើភូមិនេះមានសត្វចិញ្ចឹមប៉ុន្មានប្រភេទ?
>> ដាក់មនុស្សក្នុងភូមិជាក្រុមៗតាមអាយុ
>> អ្នកណាខ្លះគ្រប់អាយុបោះឆ្នោត អ្នកណាខ្លះមិនទាន់គ្រប់អាយុបោះឆ្នោត? (១៨ឆ្នាំឡើងទើបអាចបោះឆ្នោតបាន)
>> បង្ហាញឈ្មោះអ្នកដែលចិញ្ចឹមសត្វ តាមប្រភេទសត្វនីមួយៗ។
>> បង្ហាញឈ្មោះនិងអាយុរបស់អ្នកដែល ចិញ្ចឹមឆ្មាតែអត់ចិញ្ចឹមសុនក ភេទស្រី ដែលមានអាយុចន្លោះពី១៩ ទៅ ២១

រយៈពេលធ្វើ៣ថ្ងៃ
	 */
	public static void main(String[] args) {

		People[] people = people();
		ApplicationService.showLine("list all people");
		Stream<People> s = Stream.of(people);
		s.forEach(a -> System.out.println(a));

		ApplicationService.showLine("showPeopleMaleAndFemale");
		ApplicationService.showPeopleMaleAndFemale(people);

		ApplicationService.showLine("showPeoPleHasPetsMoreThanOne");
		ApplicationService.showPeoPleHasPetsMoreThanOne(people, 1);

		ApplicationService.showLine("showPeoplePetsCat");
		ApplicationService.showPeoplePetsCat(people,PetType.Cat);

		ApplicationService.showLine("showMeleAndFemalePetCat");
		ApplicationService.showMeleAndFemalePetCat(people,Cat);

		ApplicationService.showLine("showPeoPleNoPet");
		ApplicationService.showPeoPleNoPet(people);

		ApplicationService.showLine("showMinAgeOfPeople");
		ApplicationService.showMinAgeOfPeople(people);
		
		ApplicationService.showLine("showTypeOfPet");
		ApplicationService.showTypeOfPet(people);
		
		ApplicationService.showLine("showGroupByAge");
		ApplicationService.showGroupByAge(people);
		
		ApplicationService.showLine("showPeopleAgeUpper18andLower18");
		ApplicationService.showPeopleAgeUpper18andLower18(people);
		
		ApplicationService.showLine("showPeopleNameByAge");
		ApplicationService.showPeopleNameByAge(people);
		
		ApplicationService.showLine("showPeopleNameAndAgeHasCatNoDogFemaleAge19to21");
		ApplicationService.showPeopleNameAndAgeHasCatNoDogFemaleAge19to21(people);
		
		
		 

	}

	static People[] people() {

		List<PetType> KhemPet = List.of(PetType.Cat,PetType.Dog);
		People p1 = new People("khem", "M", 21, KhemPet);

		List<PetType> DaraPet = List.of(PetType.Cat); 
		People p2 = new People("Dara", "M", 19, DaraPet);
		List<PetType> khatPet = List.of(PetType.Dog); 
		People p3 = new People("khat", "M", 17, khatPet);

		List<PetType> kaPet = List.of(PetType.Cat); 
		People p4 = new People("ka", "F", 22, kaPet);

		List<PetType> joPet = List.of( ); 
		People p5 = new People("Jo", "F", 24, joPet);

		List<PetType> FiPet = List.of(PetType.Fish); 
		People p6 = new People("Fi", "F", 22, FiPet);

		List<PetType> RiPet = List.of(PetType.Cat); 
		People p7 = new People("Ri", "F", 21, RiPet);

		List<PetType> YiPet = List.of(PetType.Fish); 
		People p8 = new People("Yi", "F", 22, YiPet);

		List<PetType> kuPet = List.of(PetType.Cat); 
		People p9 = new People("Ku", "F", 17, kuPet);

		List<PetType> DaPet = List.of(PetType.Cat,PetType.Cow); 
		People p10 = new People("Da", "F", 20, DaPet);

		People[] p = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10 };

		return p;
	}

}
