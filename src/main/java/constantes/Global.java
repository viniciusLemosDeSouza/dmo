package constantes;


public enum Global {

    APP("https://magento.softwaretestingboard.com");



    private String s;
    Global(String s){this.s = s;}
    public String getS(){
        return this.s;
    }

}
