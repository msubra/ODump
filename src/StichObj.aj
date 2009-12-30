import java.lang.reflect.Field;


public aspect StichObj {
	
    
    public pointcut dump(boolean b) :
        call(* *.dump(..)) && args(b) ;

    before(boolean d1): dump(boolean){
    	Dumper.dump(this);
    }
	
//	 /** call to factorial, with argument */
//    pointcut f(boolean dump) : call(int Fact.factorial(this)) && args(dump);
//
//    /** print most-recent recursive call */
//    before(boolean dump, final int j)   { 
//        System.err.println(i + "-" + j);
//    }
//    
//	
//    pointcut stich(String s) : 
//    	call(public void *.toString(String)) ;
//    
//    /** print most-recent recursive call */
//    before(String v, Object o) : f(i) && cflowbelow(f(j)) { 
//        System.err.println(i + "-" + j);
//    }
//
//    
//    /** 
//     * Check input and result for a field set.
//     */
//    void around(Object input, Object targ) :  
//    	set(* *) && args(input) && target(targ) {
//    	
//    	Field[] f = targ.getClass().getDeclaredFields();
//    	
//    	for (int i = 0; i < f.length; i++) {
//			System.out.println(f[i]);
//		}
//    	
//        proceed(input, targ);
//    }
//
//    
//    after() : 
//    stich() {
//        System.out.println("Thank you!");
//        System.out.println();
//    }
    
}
