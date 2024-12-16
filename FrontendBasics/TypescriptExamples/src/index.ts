// const message: string = "Hello World";
// console.log(message);

// function add(a: number,b:number ): number{
//     return a+b
// }

// console.log(add(25,34));
// console.log(add(45,45));
// below with show error
//console.log(add("25",34));


// interface User{
//     id: number;
//     name: string;
//     email: string;
// }


// function sendEmail(user: User): void{
//     console.log(`Sending email to ${user.email}`);
// }


// const user: User = {id: 1, name: "John Doe", email:"john.doe@gmail.com"};
// sendEmail(user);

// class Person{
//     private ssn: string;
//     protected age: number;
//     public name: string;


//     constructor(name: string, age: number, ssn: string){
//         this.name = name;
//         this.age = age;
//         this.ssn = ssn;
//     }

//     public getDetails(): string {
//         return `${this.name} is ${this.age} years old`
//     }
// }

// const p1 = new Person("John Doe", 30, "123456");
// console.log(p1.getDetails());

// enum Direction{
//     NORTH,
//     SOUTH,
//     EAST,
//     WEST
// }

// function move(direction: Direction): void{
//     switch(direction){
//         case Direction.NORTH:
//             console.log("Moving North");
//             break;
//         case Direction.EAST:
//             console.log("Moving East");
//             break;
//         case Direction.SOUTH:
//             console.log("Moving South");
//             break;
//         case Direction.WEST:
//             console.log("Moving West");
//             break;
//     }
// }

// move(Direction.NORTH);
// move(Direction.EAST);


// function identity<T>(value: T): T{
//     return value;
// }

// console.log(identity<string>("Hello"));
// console.log(identity<number>(365));


// class Box<T>{
//     contents: T;

//     constructor(contents: T){
//         this.contents = contents;
//     }

//     getContents(): T{
//         return this.contents;
//     }
// }

// const stringBox = new Box<string>("A book");
// console.log(stringBox.getContents());


// Union
// function printId(id: number| string): void{
//     console.log(`Your id is: ${id}`);
// }

// printId(101);
// printId("CT1023");

// Intersection
// interface CanFly{
//     fly(): void;
// }

// interface CanSwim{
//     swim(): void;
// }

// type AmphibiousVehicle = CanFly & CanSwim;

// // interface AmphibiousVehicle{
// //     fly(): void;
// //     swim(): void;
// // }

// const vehicle: AmphibiousVehicle = {
//     fly: () => console.log("Flying"),
//     swim: () => console.log("Swimming")
// }

// vehicle.fly();
// vehicle.swim();


// aliases
// type Point = {
//     x: number,
//     y: number
// }


// type Circle = Point & {
//     radius: number
// }

// const myCircle: Circle = {
//     x:10,
//     y:15,
//     radius:20
// }

// console.log(myCircle);


// Utility Types
interface Task{
    title: string,
    description: string,
    completed: boolean
}

// Partial types makes fields optional
const draftTask: Partial<Task> ={
    title: "Drafting task"
}

// Readonly variables with immutable fields
const readOnlyTask: Readonly<Task> ={
    title: "Completed Task",
    description: "Completed Readonly Task",
    completed: false
}

















