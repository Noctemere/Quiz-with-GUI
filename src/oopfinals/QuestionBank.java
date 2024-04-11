// QuestionBank.java
package OOPFinals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;

public class QuestionBank {
    private Map<String, Question> questions = new HashMap<>();

    public List<Question> getQuestionsForTopic(TopicEnum topic) {
        return questions.values().stream()
                        .filter(question -> question.getTopic() == topic)
                        .collect(Collectors.toList());
    }
    
    public QuestionBank() {
        // Pre-defined multiple-choice questions
        MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion("""
            What must the initialization be so that the following fragment prints out the integers -3 -2 -1 ?
            for ( _______; j < 0; j++\t)
            System.out.print( j + " " );
            System.out.println( );""",
            new ArrayList<>(Arrays.asList(
            "int j < 0", 
            "int j = 0", 
            "int j = -4", 
            "int j = -3")),
            "int j = -3",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq2 = new MultipleChoiceQuestion("""
            The _______ loop facilitates evaluation of condition or expression at the end of the loop to ensure 
            that the statements are executed at least once.""",
            new ArrayList<>(Arrays.asList(
            "while",
            "do while",
            "for")),
            "do while",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq3 = new MultipleChoiceQuestion("""
            What will be the output of the following program?
            class ArrayOutput
            {
                public static void main(String s[])
                {
                    int a[] = {12, 15, 16, 17, 19, };
            
                    for(int i = 0; i < 5; i += 1)
                    {
                        System.out.print(a[i] + " ");
                    }
                }
            """,
            new ArrayList<>(Arrays.asList(
            "12 15 16 17 ", 
            "12 16 19", 
            "Compilation Error", 
            "12 15 16 17 19")),
            "12 15 16 17 19",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq4 = new MultipleChoiceQuestion("""
            How do you access an array element?""",
            new ArrayList<>(Arrays.asList(
            "By the name of the array followed by the index value in brackets.", 
            "By the index value followed by a dot and then the name of the array.", 
            "By the name of the array followed by a dot and then the index value.", 
            "None of the Choices")),
            "By the name of the array followed by the index value in brackets.",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq5 = new MultipleChoiceQuestion("""
            What is the output of the following program fragment?
            for ( int j = 0;  j <  5; j++ )
            {
            System.out.print( j + " " );
            }
            System.out.println( );""",
            new ArrayList<>(Arrays.asList(
            "0 1 2 3 4", 
            "0 1 2 3 4 5 ", 
            "0 1 2 3 4 5", 
            "j j j j j")),
            "0 1 2 3 4",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq6 = new MultipleChoiceQuestion("""
            The statements associated with this keyword are executed if the value of the switch variable does not
            match any of the case constants.""",
            new ArrayList<>(Arrays.asList(
            "default", 
            "else", 
            "last option")),
            "default",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );

        MultipleChoiceQuestion mcq7 = new MultipleChoiceQuestion("""
            For which of the following applications is an array NOT suitable:""",
            new ArrayList<>(Arrays.asList(
            "Holding the name, social security number, age, and income of one individual.", 
            "Holding the total sales a store made in each of twelve months.", 
            "Holding the temperature readings taken every hour throughout a day.", 
            "Holding the scores on twelve midterms exams of a class.")),
            "Holding the name, social security number, age, and income of one individual.",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq8 = new MultipleChoiceQuestion("""
            The ______ loop executes a given statement or block of statements repeatedly as long as the value of 
            the expression is true.
            """,
            new ArrayList<>(Arrays.asList(
            "switch", 
            "case", 
            "for", 
            "while")),
            "while",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        MultipleChoiceQuestion mcq9 = new MultipleChoiceQuestion("""
            What is it called where child object gets killed if parent object is killed?
            """,
            new ArrayList<>(Arrays.asList(
            "Encapsulation", 
            "Composition", 
            "Aggregation", 
            "Association")),
            "Composition",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        MultipleChoiceQuestion mcq10 = new MultipleChoiceQuestion("""
            When Overloading does not occur?
            """,
            new ArrayList<>(Arrays.asList(
            "More than one method with same name, same signature but different number of signature", 
            "More than one method with same name, same signature, same number of parameters but different type", 
            "More than one method with same name, same number of parameters and type but different signature", 
            "More than one method with same name but different method signature and different number or type of parameters")),
            "More than one method with same name, same number of parameters and type but different signature",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        MultipleChoiceQuestion mcq11 = new MultipleChoiceQuestion("""
            These variables identify the data stored in the object.
            """,
            new ArrayList<>(Arrays.asList(
            "Attributes", 
            "charac", 
            "methods")),
            "Attributes",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        MultipleChoiceQuestion mcq12 = new MultipleChoiceQuestion("""
            Encapsulation is also called as?
            """,
            new ArrayList<>(Arrays.asList(
            "Data Hidding", 
            "Data Hiding", 
            "None of the choices", 
            "Data Encapsulation")),
            "Data Hiding",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        MultipleChoiceQuestion mcq13 = new MultipleChoiceQuestion("""
            Which among the following violates the principle of encapsulation almost always?
            """,
            new ArrayList<>(Arrays.asList(
            "Array variables", 
            "Public variables", 
            "Global variables", 
            "Local variables")),
            "Global variables",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        MultipleChoiceQuestion mcq14 = new MultipleChoiceQuestion("""
            Single level inheritance is safer than ________?
            """,
            new ArrayList<>(Arrays.asList(
            "Implementations", 
            "Multiple inheritance", 
            "Interfaces", 
            "Extensions")),
            "Multiple inheritance",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        MultipleChoiceQuestion mcq15 = new MultipleChoiceQuestion("""
            Here is an abstract method defined in the parent: public abstract int sumUp ( int[] arr ); Which of 
            the following is required in a non-abstract child?
            """,
            new ArrayList<>(Arrays.asList(
            "public int sumUp ( long[] arr ) { . . . }", 
            "public abstract int sumUp ( int[] arr ) { . . . }", 
            "public double sumUp ( int[] arr ) { . . . } ", 
            "public int sumUp ( int[] arr ) { . . . }")),
            "public int sumUp ( int[] arr ) { . . . }",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq16 = new MultipleChoiceQuestion("""
            What is polymorphism in Java?
            """,
            new ArrayList<>(Arrays.asList(
            "It is when a class has several methods with the same name but different parameter types.", 
            "It is when a single parent class has many child classes.", 
            "It is when a program uses several different types of objects, each with its own variable.", 
            "It is when a single variable is used with several different types of related objects at different places in a program.")),
            "It is when a single variable is used with several different types of related objects at different places in a program.",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq17 = new MultipleChoiceQuestion("""
            Which of the following classes fail to compile?
            class X { abstract void method(); }
            abstract class Y extends X { }
            class Z extends Y { void method() { } }
            """,
            new ArrayList<>(Arrays.asList(
            "Z", 
            "Y", 
            "X, Y, Z", 
            "X")),
            "X",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq18 = new MultipleChoiceQuestion("""
            In terms of stream and files _____?
            """,
            new ArrayList<>(Arrays.asList(
            "Abstraction is called a stream and device is called a file", 
            "Abstraction can't be defined in terms of files and stream", 
            "Abstraction is called a file and device is called a stream", 
            "Abstraction can be called both file and stream")),
            "Abstraction is called a stream and device is called a file",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq19 = new MultipleChoiceQuestion("""
            If two classes combine some private data members and provides public member functions to access and 
            manipulate those data members. Where is abstraction used?
            """,
            new ArrayList<>(Arrays.asList(
            "Using class concept with both data members and member functions", 
            "Using public member functions to access and manipulate the data members", 
            "Using private access specifier for data members", 
            "Data is not sufficient to decide what is being used")),
            "Using public member functions to access and manipulate the data members",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq20 = new MultipleChoiceQuestion("""
            Which one is runtime polymorphism?
            """,
            new ArrayList<>(Arrays.asList(
            "Both 1 and 2", 
            "option2: MethodOverriding", 
            "None of the above", 
            "option1: MethodOverloading")),
            "option2: MethodOverriding",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq21 = new MultipleChoiceQuestion("""
            Can an object of a child type be assigned to a variable of the parent type? 
            For example, Card crd; BirthDay bd = new BirthDay("Lucinda", 42); crd = bd; // is this correct?
            """,
            new ArrayList<>(Arrays.asList(
            "Yes--an object can be assigned to a reference variable of the parent type.", 
            "Yes--any object can be assgned to any reference variable.", 
            "No--there must always be an exact match between the variable and the object types.", 
            "No--but a object of parent type can be assigned to a variable of child type.")),
            "Yes--an object can be assigned to a reference variable of the parent type.",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq22 = new MultipleChoiceQuestion("""
            What must a non-abstract child do about an abstract method in its parent class?
            """,
            new ArrayList<>(Arrays.asList(
            "A child must not define any method with the same signature as the parent's abstract method.", 
            "A child must define an additional method similar to the one inherited from its parent by defining a method with the same signature and different return type.", 
            "A child must override an abstract method inherited from its parent by defining a method with the same signature and same return type.", 
            "A non-abstract child must define an abstract method with the same signature and same return type as the parent's abstract method.")),
            "A child must override an abstract method inherited from its parent by defining a method with the same signature and same return type.",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq23 = new MultipleChoiceQuestion("""
            In case of using abstract class or function overloading, which function is supposed to be called first?
            """,
            new ArrayList<>(Arrays.asList(
            "Local function", 
            "Function with highest priority in compiler", 
            "Global function", 
            "Function with lowest priority because it might have been halted since long time, because of low priority")),
            "Function with highest priority in compiler",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        MultipleChoiceQuestion mcq24 = new MultipleChoiceQuestion("""
            Which class is used to handle the input and output exceptions?
            """,
            new ArrayList<>(Arrays.asList(
            "ExceptionsIO", 
            "IOExceptions", 
            "InputOutput", 
            "InputOutputExceptions")),
            "IOExceptions",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq25 = new MultipleChoiceQuestion("""
            What will happen when you compile and run the following code?
            public class Test{ 
             	public static void main(String[] args){
                  	try{
                       	Test t = new Test();
                       	int d = t.getNum(2, 5);
                       	System.out.println(d);  
                  	}catch(Exception e){
                       	System.out.print("Exception 1 ");
                  	}
             	}
             	public int getNum(int a, int b){
                  	int c = 0;
                  	try{
                       	c = a * b;
                       	if(c > 10)
                             	throw new String("Cannot be more than 10 ");   
                  	}catch(Exception e){
                       	System.out.print("Exception 2 ");
                  	}
                  	return c;
             	}
            }
            """,
            new ArrayList<>(Arrays.asList(
            "Compilation error", 
            "10", 
            "Exception 2", 
            "Exception 2 Exception1")),
            "Compilation error",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq26 = new MultipleChoiceQuestion("""
            What will be the output of the following program?
            public class BlockFinal {
            	public static void main(String[] a) {
                	try {
                            int i = 10 / 0;
                	}
                	catch (Exception ex) {
                            System.out.println("1st catch Block");
                	}
                	finally {
                            System.out.println("1st finally block");
                	}
                	try {
                            int i = 10 / 10;
                	}
                	catch (Exception ex) {
                            System.out.println("2nd catch Block");
                	}
                	finally {
                            System.out.println("2nd finally block");
                	}
            	}
            }
            """,
            new ArrayList<>(Arrays.asList(
            "1st catch Block\n   2nd catch Block ", 
            "1st finally block\n   2nd finally block", 
            "1st catch Block\n   1st finally block\n   2nd catch Block\n   2nd finally block", 
            "1st catch Block\n   1st finally block\n   2nd finally block")),
            "1st catch Block\n   1st finally block\n   2nd finally block",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq27 = new MultipleChoiceQuestion("""
            What will be the output of the program (when you run with the -ea option)?
            public class Test { 
            	public static void main(String[] args) {
                    int x = 0; 
                    assert (x > 0) : "assertion failed"; /* Line 6 */
                    System.out.println("finished");
            	}
            }
            """,
            new ArrayList<>(Arrays.asList(
            "An AssertionError is thrown and finished is output.", 
            "An AssertionError is thrown.", 
            "Compilation fails.", 
            "finished")),
            "An AssertionError is thrown.",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq28 = new MultipleChoiceQuestion("""
            Which statement is true?
            """,
            new ArrayList<>(Arrays.asList(
            "Conditional compilation is used to allow tested classes to run at full speed", 
            "Assertions can be enabled or disabled on a class-by-class basis.", 
            "Assertions are appropriate for checking the validity of arguments in a method.", 
            "The programmer can choose to execute a return statement or to throw an exception if an assertion fails.")),
            "Assertions can be enabled or disabled on a class-by-class basis.",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq29 = new MultipleChoiceQuestion("""
            public class Test2 {
            
                public static int x;
            
                public static int foo(int y) {
                    return y * 2;
                }

                public static void main(String [] args) {
                    int z = 5;
                    assert z > 0; /* Line 11 */
                    assert z > 2: foo(z); /* Line 12 */
            
                    if ( z < 7 )
                        assert z > 4; /* Line 14 */
            
                    switch (z) {
                        case 4: System.out.println("4 ");
                        case 5: System.out.println("5 ");
                        default: assert z < 10;
                    }
                                                                  
                    if ( z < 10 )
                        assert z > 4: z++; /* Line 22 */
            
                    System.out.println(z);
                }
            }
            Which line is an example of an inappropriate use of assertions?
            """,
            new ArrayList<>(Arrays.asList(
            "Line 20", 
            "Line 22", 
            "Line 25", 
            "Line 23")),
            "Line 22",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq30 = new MultipleChoiceQuestion("""
            public class Test { 
            
                public void foo() {
                    assert false; /* Line 5 */
                    assert false; /* Line 6 */
            
                } 
            
                public void bar() {
                                                                  
                    while(true) {
                        assert false; /* Line 12 */
                    } 
                    assert false;  /* Line 14 */
                } 
            }
            What causes compilation to fail?
            """,
            new ArrayList<>(Arrays.asList(
            "Line 10", 
            "Line 14", 
            "Line 13", 
            "Line 12")),
            "Line 14",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq31 = new MultipleChoiceQuestion("""
            Why do we use finally block?
            """,
            new ArrayList<>(Arrays.asList(
            "To execute a code with each and every run of program", 
            "To execute the block if exception occurred", 
            "To execute a code whenever required", 
            "To execute a code when exception is not occurred")),
            "To execute a code with each and every run of program",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq32 = new MultipleChoiceQuestion("""
            A method must do either of two things with a checked exception. What are those two things?
            """,
            new ArrayList<>(Arrays.asList(
            "(1) Handle the exception in a catch{} block, or \n   (2) handle the exception in a try{} block,",
            "(1) Handle the exception in a catch{} block, or \n   (2) return the exception to the sender.", 
            "(1) Ignore the exception, or (2) check the exception. ",
            "(1) Handle the exception in a catch{} block, or \n   (2) throw the exception to the method that called this method.")),
            "(1) Handle the exception in a catch{} block, or \n   (2) throw the exception to the method that called this method.",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        MultipleChoiceQuestion mcq33 = new MultipleChoiceQuestion("""
            In using __________, unlike FileOutputStream class, you don't need to convert string into byte array 
            because it provides a method to write string directly.
            """,
            new ArrayList<>(Arrays.asList(
            "WriteFile class", 
            "FileWrite class", 
            "WriterFile class", 
            "FileWriter class")),
            "FileWriter class",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        MultipleChoiceQuestion mcq34 = new MultipleChoiceQuestion("""
            What is the correct difference between HashMap and TreeMap?
            """,
            new ArrayList<>(Arrays.asList(
            "HashMap can contain duplicate elements whereas TreeMap contains only unique elements.", 
            "None", 
            "HashMap maintains no order but TreeMap maintains ascending order.", 
            "HashMap contains only values whereas TreeMap contains key and values both.")),
            "HashMap maintains no order but TreeMap maintains ascending order.",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        MultipleChoiceQuestion mcq35 = new MultipleChoiceQuestion("""
            How many ways does the java.lang.Comparable interface allow us to sort a collection?
            """,
            new ArrayList<>(Arrays.asList(
            "2", 
            "0", 
            "any number", 
            "1")),
            "1",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        MultipleChoiceQuestion mcq36 = new MultipleChoiceQuestion("""
            What is returned from both the compare() and compareTo() methods?
            """,
            new ArrayList<>(Arrays.asList(
            "boolean", 
            "int", 
            "char", 
            "string")),
            "int",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        MultipleChoiceQuestion mcq37 = new MultipleChoiceQuestion("""
            What does the 'FileOutputStream' class do?
            """,
            new ArrayList<>(Arrays.asList(
            "It is used to read data from a file", 
            "It is used to read data from the keyboard", 
            "It is used to write data to a file", 
            "It is used to create directories")),
            "It is used to write data to a file",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        MultipleChoiceQuestion mcq38 = new MultipleChoiceQuestion("""
            It is the superclass of all classes representing an output stream of bytes.
            """,
            new ArrayList<>(Arrays.asList(
            "StreamOutput", 
            "OutputStream", 
            "StreamOut", 
            "OutStream")),
            "OutputStream",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        MultipleChoiceQuestion mcq39 = new MultipleChoiceQuestion("""
            What type of collection does not extend the Collection interface?
            """,
            new ArrayList<>(Arrays.asList(
            "Set", 
            "Map", 
            "Queue", 
            "List")),
            "Map",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        
        // Pre-defined true/false questions
        TrueFalseQuestion tfq1 = new TrueFalseQuestion(
            """
            The while loop executes a given statement or a block of statements for a definite number of times.""",
            "True",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        TrueFalseQuestion tfq2 = new TrueFalseQuestion(
            """
            The continue statement causes the program flow to exit prematurely from the body of the loop statement.""",
            "False",
            TopicEnum.CONTROL_STRUCTURES_AND_ARRAY
        );
        
        TrueFalseQuestion tfq3 = new TrueFalseQuestion("""
            Accessor (Getter) – a method that is used to change the data.
            """,
            "False",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        TrueFalseQuestion tfq4 = new TrueFalseQuestion("""
            Constructor – declared either at the start or end of a class definition. These variables identify the 
            data stored in the object.
            """,
            "False",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        TrueFalseQuestion tfq5 = new TrueFalseQuestion("""
            'this' keyword can be used to invoke current class method (implicitly)
            """,
            "True",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        TrueFalseQuestion tfq6 = new TrueFalseQuestion("""
            In Encapsulation, the programmer can change one part of the code without affecting other parts
            """,
            "True",
            TopicEnum.ENCAPSULATION_AND_INHERITANCE
        );
        
        TrueFalseQuestion tfq7 = new TrueFalseQuestion("""
            An interface is typically used in place of an abstract class when there is no default implementation 
            to inherit.
            """,
            "True",
            TopicEnum.POLYMORPHISM_AND_ABSTRACTION
        );
        
        TrueFalseQuestion tfq8 = new TrueFalseQuestion("""
            )Only way to enable assertion for your program is by using command line arguments.
            """,
            "False",
            TopicEnum.EXCEPTIONS_AND_ASSERTIONS
        );
        
        TrueFalseQuestion tfq9 = new TrueFalseQuestion("""
            The following code is snippet valid?
            List aList = new ArrayList();
            """,
            "False",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        TrueFalseQuestion tfq10 = new TrueFalseQuestion("""
            System.err is the standard error stream.
            """,
            "True",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );
        
        TrueFalseQuestion tfq11 = new TrueFalseQuestion("""
            Java FileReader class is a character-oriented class which is used for file handling in java.
            """,
            "True",
            TopicEnum.COLLECTIONS_AND_INPUT_AND_OUTPUT_STREAM
        );

        // Add questions to the QuestionBank using a unique identifier
        questions.put("MCQ1", mcq1);
        questions.put("MCQ2", mcq2);
        questions.put("MCQ3", mcq3);
        questions.put("MCQ4", mcq4);
        questions.put("MCQ5", mcq5);
        questions.put("MCQ6", mcq6);
        questions.put("MCQ7", mcq7);
        questions.put("MCQ8", mcq8);
        questions.put("MCQ9", mcq9);
        questions.put("MCQ10", mcq10);
        questions.put("MCQ11", mcq11);
        questions.put("MCQ12", mcq12);
        questions.put("MCQ13", mcq13);
        questions.put("MCQ14", mcq14);
        questions.put("MCQ15", mcq15);
        questions.put("MCQ16", mcq16);
        questions.put("MCQ17", mcq17);
        questions.put("MCQ18", mcq18);
        questions.put("MCQ19", mcq19);
        questions.put("MCQ20", mcq20);
        questions.put("MCQ21", mcq21);
        questions.put("MCQ22", mcq22);
        questions.put("MCQ23", mcq23);
        questions.put("MCQ24", mcq24);
        questions.put("MCQ25", mcq25);
        questions.put("MCQ26", mcq26);
        questions.put("MCQ27", mcq27);
        questions.put("MCQ28", mcq28);
        questions.put("MCQ29", mcq29);
        questions.put("MCQ30", mcq30);
        questions.put("MCQ31", mcq31);
        questions.put("MCQ32", mcq32);
        questions.put("MCQ33", mcq33);
        questions.put("MCQ34", mcq34);
        questions.put("MCQ35", mcq35);
        questions.put("MCQ36", mcq36);
        questions.put("MCQ37", mcq37);
        questions.put("MCQ38", mcq38);
        questions.put("MCQ39", mcq39);
        
        questions.put("TFQ1", tfq1);
        questions.put("TFQ2", tfq2);
        questions.put("TFQ3", tfq3);
        questions.put("TFQ4", tfq4);
        questions.put("TFQ5", tfq5);
        questions.put("TFQ6", tfq6);
        questions.put("TFQ7", tfq7);
        questions.put("TFQ8", tfq8);
        questions.put("TFQ9", tfq9);
        questions.put("TFQ10", tfq10);
        questions.put("TFQ11", tfq11);        
    }

    public Map<String, Question> getQuestions() {
        return questions;
    }
    
  public String getQuestionId(Question question) {
    for (Map.Entry<String, Question> entry : questions.entrySet()) {
        if (entry.getValue() == question) {
            return entry.getKey();
        }
    }
        return null; // Handle the case where the question is not found
    }   
  
    public List<Question> getRandomizedQuestions() {
        List<Question> randomizedQuestions = new ArrayList<>(questions.values());
        Collections.shuffle(randomizedQuestions);
        return randomizedQuestions;
    }

    public void displayQuestions() {
        for (Map.Entry<String, Question> entry : questions.entrySet()) {
            System.out.println("Question ID: " + entry.getKey());
            entry.getValue().display();
            System.out.println();  // Add a line break between questions for better readability
        }
    }
}
