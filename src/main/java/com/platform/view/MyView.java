package com.platform.view;

import com.platform.controller.*;
import com.platform.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;

@Component
public class MyView {
	private final AdressController adressController;
    private final CityController cityController;
    private final DwellingController dwellingController;
    private final DwellingOwnerController dwellingOwnerController;
    private final LesseeController lesseeController;
    private final LesseeFeedbackController lesseeFeedbackController;
    private final OwnerFeedbackController ownerFeedbackController;
    private final PlatformUserController platformUserController;
    private final RegionController regionController;
    private final ReservationController reservationController;
    
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    
    public MyView(PlatformUserController platformUserController, OwnerFeedbackController ownerFeedbackController,
    		LesseeController lesseeController, DwellingOwnerController dwellingOwnerController,
    		DwellingController dwellingController, CityController cityController, CityController cityController2,
    		AdressController adressController, LesseeFeedbackController lesseeFeedbackController,
    		ReservationController reservationController, RegionController regionController) {
        this.adressController = adressController;
		this.cityController = cityController2;
		this.dwellingController = dwellingController;
		this.dwellingOwnerController = dwellingOwnerController;
		this.lesseeController = lesseeController;
		this.lesseeFeedbackController = lesseeFeedbackController;
		this.ownerFeedbackController = ownerFeedbackController;
		this.platformUserController = platformUserController;
		this.regionController = regionController;
		this.reservationController = reservationController;
		
		this.menu = new LinkedHashMap<>();
        this.methodsMenu = new HashMap<>();
		
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Dwelling");
        menu.put("11", "  11 - Create Dwelling");
        menu.put("12", "  12 - Update Dwelling");
        menu.put("13", "  13 - Delete Dwelling");
        menu.put("14", "  14 - Find all Dwellings");
        menu.put("15", "  15 - Find Dwelling by ID");

        menu.put("2", "   2 - Table: City");
        menu.put("21", "  21 - Create City");
        menu.put("22", "  22 - Update City");
        menu.put("23", "  23 - Delete City");
        menu.put("24", "  24 - Find all Cities");
        menu.put("25", "  25 - Find City by ID");

        menu.put("3", "   3 - Table: PlatformUser");
        menu.put("31", "  31 - Create PlatformUser");
        menu.put("32", "  32 - Update PlatformUser");
        menu.put("33", "  33 - Delete PlatformUser");
        menu.put("34", "  34 - Find all PlatformUsers");
        menu.put("35", "  35 - Find PlatformUser by ID");
        
        menu.put("4", "   4 - Table: Lessee");
        menu.put("41", "  41 - Create Lessee");
        menu.put("42", "  42 - Update Lessee");
        menu.put("43", "  43 - Delete Lessee");
        menu.put("44", "  44 - Find all Lessees");
        menu.put("45", "  45 - Find Lessee by ID");
        
        menu.put("5", "   5 - Table: DwellingOwner");
        menu.put("51", "  51 - Create DwellingOwner");
        menu.put("52", "  52 - Update DwellingOwner");
        menu.put("53", "  53 - Delete DwellingOwner");
        menu.put("54", "  54 - Find all DwellingOwners");
        menu.put("55", "  55 - Find DwellingOwner by ID");
        
        menu.put("6", "   6 - Table: Reservation");
        menu.put("61", "  61 - Create Reservation");
        menu.put("62", "  62 - Update Reservation");
        menu.put("63", "  63 - Delete Reservation");
        menu.put("64", "  64 - Find all Reservations");
        menu.put("65", "  65 - Find Reservation by ID");
        
        menu.put("7", "   7 - Table: Adress");
        menu.put("71", "  71 - Create Adress");
        menu.put("72", "  72 - Update Adress");
        menu.put("73", "  73 - Delete Adress");
        menu.put("74", "  74 - Find all Adresses");
        menu.put("75", "  75 - Find Adress by ID");
        
        menu.put("8", "   8 - Table: Region");
        menu.put("81", "  81 - Create Region");
        menu.put("82", "  82 - Update Region");
        menu.put("83", "  83 - Delete Region");
        menu.put("84", "  84 - Find all Regions");
        menu.put("85", "  85 - Find Region by ID");
        
        menu.put("9", "   9 - Table: LesseeFeedback");
        menu.put("91", "  91 - Create LesseeFeedback");
        menu.put("92", "  92 - Update LesseeFeedback");
        menu.put("93", "  93 - Delete LesseeFeedback");
        menu.put("94", "  94 - Find all LesseeFeedbacks");
        menu.put("95", "  95 - Find LesseeFeedback by ID");
        
        menu.put("0", "   0 - Table: OwnerFeedback");
        menu.put("101", "  101 - Create OwnerFeedback");
        menu.put("102", "  102 - Update OwnerFeedback");
        menu.put("103", "  103 - Delete OwnerFeedback");
        menu.put("104", "  104 - Find all OwnerFeedbacks");
        menu.put("105", "  105 - Find OwnerFeedback by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createDwelling);
        methodsMenu.put("12", this::updateDwelling);
        methodsMenu.put("13", this::deleteDwelling);
        methodsMenu.put("14", this::findAllDwelings);
        methodsMenu.put("15", this::findDwellingById);

        methodsMenu.put("21", this::createCity);
        methodsMenu.put("22", this::updateCity);
        methodsMenu.put("23", this::deleteCity);
        methodsMenu.put("24", this::findAllCities);
        methodsMenu.put("25", this::findCityById);

        methodsMenu.put("31", this::createPlatformUser);
        methodsMenu.put("32", this::updatePlatformUser);
        methodsMenu.put("33", this::deletePlatformUser);
        methodsMenu.put("34", this::findAllPlatformUsers);
        methodsMenu.put("35", this::findPlatformUserById);
        
        methodsMenu.put("41", this::createLessee);
        methodsMenu.put("42", this::updateLessee);
        methodsMenu.put("43", this::deleteLessee);
        methodsMenu.put("44", this::findAllLessees);
        methodsMenu.put("45", this::findLesseeById);
        
        methodsMenu.put("51", this::createDwellingOwner);
        methodsMenu.put("52", this::updateDwellingOwner);
        methodsMenu.put("53", this::deleteDwellingOwner);
        methodsMenu.put("54", this::findAllDwellingOwners);
        methodsMenu.put("55", this::findDwellingOwnerById);
        
        methodsMenu.put("61", this::createReservation);
        methodsMenu.put("62", this::updateReservation);
        methodsMenu.put("63", this::deleteReservation);
        methodsMenu.put("64", this::findAllReservations);
        methodsMenu.put("65", this::findReservationById);
   
        methodsMenu.put("71", this::createAdress);
        methodsMenu.put("72", this::updateAdress);
        methodsMenu.put("73", this::deleteAdress);
        methodsMenu.put("74", this::findAllAdresses);
        methodsMenu.put("75", this::findAdressById);
        
        methodsMenu.put("81", this::createRegion);
        methodsMenu.put("82", this::updateRegion);
        methodsMenu.put("83", this::deleteRegion);
        methodsMenu.put("84", this::findAllRegions);
        methodsMenu.put("85", this::findRegionById);
        
        methodsMenu.put("91", this::createLesseeFeedback);
        methodsMenu.put("92", this::updateLesseeFeedback);
        methodsMenu.put("93", this::deleteLesseeFeedback);
        methodsMenu.put("94", this::findAllLesseeFeedbacks);
        methodsMenu.put("95", this::findLesseeFeedbackById);
        
        methodsMenu.put("101", this::createOwnerFeedback);
        methodsMenu.put("102", this::updateOwnerFeedback);
        methodsMenu.put("103", this::deleteOwnerFeedback);
        methodsMenu.put("104", this::findAllOwnerFeedbacks);
        methodsMenu.put("105", this::findOwnerFeedbackById);
    }

    private void selectAllTable() {
        findAllAdresses();
        findAllCities();
        findAllDwelings();
        findAllDwellingOwners();
        findAllLesseeFeedbacks();
        findAllLessees();
        findAllOwnerFeedbacks();
        findAllPlatformUsers();
        findAllRegions();
        findAllReservations();
    }
    
    
    
    // ========= Dwelling =========
    
    private void createDwelling() {
    	System.out.println("Input 'area': ");
    	Integer area = Integer.valueOf(input.nextLine());
    	System.out.println("Input 'floor': ");
    	Integer floor = Integer.valueOf(input.nextLine());
    	System.out.println("Input 'rooms_number': ");
    	Integer roomsNumber = Integer.valueOf(input.nextLine());
    	System.out.println("Input 'description': ");
    	String description = input.nextLine();
    	System.out.println("Input 'adress_id': ");
    	Integer adressId = Integer.valueOf(input.nextLine());
    	System.out.println("Input 'dwelling_owner_id': ");
    	Integer dwellingOwnerId = Integer.valueOf(input.nextLine());
    	System.out.println("Input 'reservation_id': ");
    	Integer reservationId = Integer.valueOf(input.nextLine());
    	
    	Dwelling dwelling = new Dwelling(null, area, floor, roomsNumber,
    			description, adressId, dwellingOwnerId, reservationId);
    	
    	try {
    		dwellingController.create(dwelling);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateDwelling() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'area': ");
    	Integer area = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'floor': ");
    	Integer floor = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'rooms_number': ");
    	Integer roomsNumber = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'description': ");
    	String description = input.nextLine();
    	System.out.println("Input new 'adress_id': ");
    	Integer adressId = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'dwelling_owner_id': ");
    	Integer dwellingOwnerId = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'reservation_id': ");
    	Integer reservationId = Integer.valueOf(input.nextLine());
    	
    	Dwelling dwelling = new Dwelling(null, area, floor, roomsNumber,
    			description, adressId, dwellingOwnerId, reservationId);
    	
    	 try {
    		 dwellingController.update(id, dwelling);
             System.out.println("Successfully updated");
         }
         catch (DataIntegrityViolationException exception) {
             System.out.println("Can`t update");
         }
    }
    
    private void deleteDwelling() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		dwellingController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllDwelings() {
    	System.out.println("\nTable: Dwelling");
        List<Dwelling> dwellings = dwellingController.findAll();
        for (Dwelling dwelling : dwellings) {
            System.out.println(dwelling);
        }
    }
    
    private void findDwellingById() {
    	 System.out.println("Input 'id': ");
         Integer id = Integer.valueOf((input.nextLine()));

         try {
             Optional<Dwelling> dwelling = dwellingController.findById(id);
             System.out.println(dwelling);
         }
         catch (DataIntegrityViolationException exception) {
             System.out.println("Can`t find");
         }
    }
    
    
    
 // ========= City =========
    
    private void createCity() {
    	System.out.println("Input 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input 'population': ");
    	Integer population = Integer.valueOf(input.nextLine());
    	System.out.println("Input 'region_id': ");
    	Integer regionId = Integer.valueOf(input.nextLine());
    	
    	City city = new City(null, name, population, regionId);
    	
    	try {
    		cityController.create(city);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateCity() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'population': ");
    	Integer population = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'region_id': ");
    	Integer regionId = Integer.valueOf(input.nextLine());
    	
    	City city = new City(null, name, population, regionId);
    	
    	try {
   		 cityController.update(id, city);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    
    private void deleteCity() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		cityController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllCities() {
    	System.out.println("\nTable: City");
        List<City> cities = cityController.findAll();
        for (City city : cities) {
            System.out.println(city);
        }
    }
    
    private void findCityById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<City> city = cityController.findById(id);
            System.out.println(city);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
    
 // ========= PlatformUser =========
    
    private void createPlatformUser() {
    	System.out.println("Input 'email': ");
    	String email = input.nextLine();
    	System.out.println("Input 'phone': ");
    	String phone = input.nextLine();
    	
    	PlatformUser platformUser = new PlatformUser(null, email, phone);
    	
    	try {
    		platformUserController.create(platformUser);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updatePlatformUser() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'email': ");
    	String email = input.nextLine();
    	System.out.println("Input new 'phone': ");
    	String phone = input.nextLine();
    	
    	PlatformUser platformUser = new PlatformUser(null, email, phone);
    	
    	try {
      		 platformUserController.update(id, platformUser);
               System.out.println("Successfully updated");
           }
           catch (DataIntegrityViolationException exception) {
               System.out.println("Can`t update");
           }
    }
    
    private void deletePlatformUser() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		platformUserController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllPlatformUsers() {
    	System.out.println("\nTable: PlatformUser");
        List<PlatformUser> platformUsers = platformUserController.findAll();
        for (PlatformUser platformUser : platformUsers) {
            System.out.println(platformUser);
        }
    }
    
    private void findPlatformUserById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<PlatformUser> platformUser = platformUserController.findById(id);
            System.out.println(platformUser);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
 // ========= Lessee =========
    
    private void createLessee() {
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'surname': ");
    	String surname = input.nextLine();
    	System.out.println("Input new 'platform_user_id': ");
    	Integer platformUserId = Integer.valueOf(input.nextLine());
    	
    	Lessee lessee = new Lessee(null, name, surname, platformUserId);
    	
    	try {
    		lesseeController.create(lessee);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateLessee() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'surname': ");
    	String surname = input.nextLine();
    	System.out.println("Input new 'platform_user_id': ");
    	Integer platformUserId = Integer.valueOf(input.nextLine());
    	
    	Lessee lessee = new Lessee(null, name, surname, platformUserId);
    	
    	try {
     		 lesseeController.update(id, lessee);
              System.out.println("Successfully updated");
          }
          catch (DataIntegrityViolationException exception) {
              System.out.println("Can`t update");
          }
    }
    
    private void deleteLessee() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		lesseeController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllLessees() {
    	System.out.println("\nTable: Lessee");
        List<Lessee> lessees = lesseeController.findAll();
        for (Lessee lessee : lessees) {
            System.out.println(lessee);
        }
    }
    
    private void findLesseeById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Lessee> lessee = lesseeController.findById(id);
            System.out.println(lessee);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
 // ========= DwellingOwner =========
    
    private void createDwellingOwner() {
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'surname': ");
    	String surname = input.nextLine();
    	System.out.println("Input new 'platform_user_id': ");
    	Integer platformUserId = Integer.valueOf(input.nextLine());
    	
    	DwellingOwner dwellingOwner = new DwellingOwner(null, name, surname, platformUserId);
    	
    	try {
    		dwellingOwnerController.create(dwellingOwner);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateDwellingOwner() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'surname': ");
    	String surname = input.nextLine();
    	System.out.println("Input new 'platform_user_id': ");
    	Integer platformUserId = Integer.valueOf(input.nextLine());
    	
    	DwellingOwner dwellingOwner = new DwellingOwner(null, name, surname, platformUserId);
    	
    	try {
    		 dwellingOwnerController.update(id, dwellingOwner);
             System.out.println("Successfully updated");
         }
         catch (DataIntegrityViolationException exception) {
             System.out.println("Can`t update");
         }
    }
    
    private void deleteDwellingOwner() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		dwellingOwnerController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllDwellingOwners() {
    	System.out.println("\nTable: DwellingOwner");
        List<DwellingOwner> dwellingOwners = dwellingOwnerController.findAll();
        for (DwellingOwner dwellingOwner : dwellingOwners) {
            System.out.println(dwellingOwner);
        }
    }
    
    private void findDwellingOwnerById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<DwellingOwner> dwellingOwner = dwellingOwnerController.findById(id);
            System.out.println(dwellingOwner);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
 // ========= Reservation =========
    
    private void createReservation() {
    	System.out.println("Input new 'is_possible': ");
    	Boolean is_possible = Boolean.valueOf(input.nextLine());
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'time': ");
    	String time = input.nextLine();
    	System.out.println("Input new 'how_long': ");
    	String howLong = input.nextLine();
    	System.out.println("Input new 'is_confirmed': ");
    	Boolean isConfirmed = Boolean.valueOf(input.nextLine());
    	System.out.println("Input new 'lessee_id': ");
    	Integer lesseeId = Integer.valueOf(input.nextLine());
    	
    	Reservation reservation = new Reservation(null, is_possible, name,
    			time, howLong, isConfirmed, lesseeId);
    	
    	try {
    		reservationController.create(reservation);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateReservation() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'is_possible': ");
    	Boolean is_possible = Boolean.valueOf(input.nextLine());
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	System.out.println("Input new 'time': ");
    	String time = input.nextLine();
    	System.out.println("Input new 'how_long': ");
    	String howLong = input.nextLine();
    	System.out.println("Input new 'is_confirmed': ");
    	Boolean isConfirmed = Boolean.valueOf(input.nextLine());
    	System.out.println("Input new 'lessee_id': ");
    	Integer lesseeId = Integer.valueOf(input.nextLine());
    	
    	Reservation reservation = new Reservation(null, is_possible, name,
    			time, howLong, isConfirmed, lesseeId);
    	
    	try {
   		 reservationController.update(id, reservation);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    
    private void deleteReservation() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		reservationController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllReservations() {
    	System.out.println("\nTable: Reservation");
        List<Reservation> reservations = reservationController.findAll();
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
    
    private void findReservationById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Reservation> reservation = reservationController.findById(id);
            System.out.println(reservation);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
 // ========= Adress =========
    
    private void createAdress() {
    	System.out.println("Input new 'street': ");
    	String street = input.nextLine();
    	System.out.println("Input new 'house_number': ");
    	Integer houseNumber = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'city_id': ");
    	Integer cityId = Integer.valueOf(input.nextLine());
    	
    	Adress adress = new Adress(null, street, houseNumber, cityId);
    	
    	try {
    		adressController.create(adress);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateAdress() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'street': ");
    	String street = input.nextLine();
    	System.out.println("Input new 'house_number': ");
    	Integer houseNumber = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'city_id': ");
    	Integer cityId = Integer.valueOf(input.nextLine());
    	
    	Adress adress = new Adress(null, street, houseNumber, cityId);
    	
    	try {
      		 adressController.update(id, adress);
               System.out.println("Successfully updated");
           }
           catch (DataIntegrityViolationException exception) {
               System.out.println("Can`t update");
           }
    }
    
    private void deleteAdress() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		adressController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllAdresses() {
    	System.out.println("\nTable: Adress");
        List<Adress> adresses = adressController.findAll();
        for (Adress adress : adresses) {
            System.out.println(adress);
        }
    }
    
    private void findAdressById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Adress> adress = adressController.findById(id);
            System.out.println(adress);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
 // ========= Region =========
    
    private void createRegion() {
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	
    	Region region = new Region(null, name);
    	
    	try {
    		regionController.create(region);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateRegion() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'name': ");
    	String name = input.nextLine();
    	
    	Region region = new Region(null, name);
    	
    	try {
     		 regionController.update(id, region);
              System.out.println("Successfully updated");
          }
          catch (DataIntegrityViolationException exception) {
              System.out.println("Can`t update");
          }
    }
    
    private void deleteRegion() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		regionController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllRegions() {
    	System.out.println("\nTable: Region");
        List<Region> regions = regionController.findAll();
        for (Region region : regions) {
            System.out.println(region);
        }
    }
    
    private void findRegionById() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        try {
            Optional<Region> region = regionController.findById(id);
            System.out.println(region);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
 // ========= LesseeFeedback =========
    
    private void createLesseeFeedback() {
    	System.out.println("Input new 'rating': ");
    	Integer rating = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'response': ");
    	String response = input.nextLine();
    	System.out.println("Input new 'lessee_id': ");
    	Integer lesseeId = Integer.valueOf(input.nextLine());
    	
    	LesseeFeedback lesseeFeedback = new LesseeFeedback(null, rating, response, lesseeId);
    	
    	try {
    		lesseeFeedbackController.create(lesseeFeedback);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateLesseeFeedback() {
    	System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        
        System.out.println("Input new 'rating': ");
    	Integer rating = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'response': ");
    	String response = input.nextLine();
    	System.out.println("Input new 'lessee_id': ");
    	Integer lesseeId = Integer.valueOf(input.nextLine());
    	
    	LesseeFeedback lesseeFeedback = new LesseeFeedback(null, rating, response, lesseeId);
    	
    	try {
    		 lesseeFeedbackController.update(id, lesseeFeedback);
             System.out.println("Successfully updated");
         }
         catch (DataIntegrityViolationException exception) {
             System.out.println("Can`t update");
         }
    }
    
    private void deleteLesseeFeedback() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		lesseeFeedbackController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllLesseeFeedbacks() {
    	System.out.println("\nTable: Region");
        List<LesseeFeedback> lesseeFeedbacks = lesseeFeedbackController.findAll();
        for (LesseeFeedback lesseeFeedback : lesseeFeedbacks) {
            System.out.println(lesseeFeedback);
        }
    }
    
    private void findLesseeFeedbackById() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());

        try {
            Optional<LesseeFeedback> lesseeFeedback = lesseeFeedbackController.findById(id);
            System.out.println(lesseeFeedback);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
 // ========= OwnerFeedback =========
    
    private void createOwnerFeedback() {
    	System.out.println("Input new 'rating': ");
    	Integer rating = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'response': ");
    	String response = input.nextLine();
    	System.out.println("Input new 'dwelling_owner_id': ");
    	Integer dwellingOwnerId = Integer.valueOf(input.nextLine());
    	
    	OwnerFeedback ownerFeedback = new OwnerFeedback(null, rating, response, dwellingOwnerId);
    	
    	try {
    		ownerFeedbackController.create(ownerFeedback);
            System.out.println("Successfully created");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t create");
        }
    }
    
    private void updateOwnerFeedback() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	System.out.println("Input new 'rating': ");
    	Integer rating = Integer.valueOf(input.nextLine());
    	System.out.println("Input new 'response': ");
    	String response = input.nextLine();
    	System.out.println("Input new 'dwelling_owner_id': ");
    	Integer dwellingOwnerId = Integer.valueOf(input.nextLine());
    	
    	OwnerFeedback ownerFeedback = new OwnerFeedback(null, rating, response, dwellingOwnerId);
    	
    	try {
   		 ownerFeedbackController.update(id, ownerFeedback);
            System.out.println("Successfully updated");
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t update");
        }
    }
    
    private void deleteOwnerFeedback() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());
    	
    	try {
    		ownerFeedbackController.delete(id);
            System.out.println("Successfully deleted");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t delete");
        }
    }
    
    private void findAllOwnerFeedbacks() {
    	System.out.println("\nTable: Region");
        List<OwnerFeedback> ownerFeedbacks = ownerFeedbackController.findAll();
        for (OwnerFeedback ownerFeedback : ownerFeedbacks) {
            System.out.println(ownerFeedback);
        }
    }
    
    private void findOwnerFeedbackById() {
    	System.out.println("Input 'id': ");
    	Integer id = Integer.valueOf(input.nextLine());

        try {
            Optional<OwnerFeedback> ownerFeedback = ownerFeedbackController.findById(id);
            System.out.println(ownerFeedback);
        }
        catch (DataIntegrityViolationException exception) {
            System.out.println("Can`t find");
        }
    }
    
    
    
    
    
    

    

    


    //-------------------------------------------------------------------------
    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    //endregion
}

