package generics01;

public class TestGenericClass50 {

	public static void main(String[] args) {
		
		Vehicle myCar = new Car () ;
		
		VehicleReg < Car > vr = new VehicleReg<Car> ((Car) myCar) ;
		
		vr.setOwner((Car)myCar);
		
		System.out.println(vr.getClass().getName());
		System.out.println(vr.getOwner().getClass().getName());
		
		Vehicle myBike = new Bike () ;
		
		VehicleReg < Bike > vr2 = new VehicleReg<Bike> ((Bike)myBike);
		
		vr2.setOwner((Bike) myBike);
		
		System.out.println(vr2.getClass().getName());
		System.out.println(vr2.getOwner().getClass().getName());
		
	}

}

class Vehicle {
	
}

class Car extends Vehicle {
	
}

class Bike extends Vehicle {
	
}

class VehicleReg < V > {
	private V v ;
	
	public VehicleReg ( V v ) {
		this.v = v ;
	}
	
	public void setOwner ( V v ) {
		this.v = v ;
	}
	
	public V getOwner ( ) {
		return this.v ;
	}
}
