public class ExceptionTest {

    public static void main(String[] args) {
        double result=0;
        ExceptionTest test = new ExceptionTest();
        try{
            result=test.areaOfRectangle(-1,10);
        }catch(CustomException e){
            System.out.println("Message: " + e.getMessage());
            System.out.println("Description: " + e.toString());
        }
        System.out.println("Result: " + result);
    }
    
    public double areaOfRectangle(double height, double width)throws CustomException{
        if(width<0 || height<0){
            throw new CustomException("Sides must be positive length.");
        }
        double area;
        area = width*height;
        return area;
    }
    
}
