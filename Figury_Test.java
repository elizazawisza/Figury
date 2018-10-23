import static java.lang.Math.*;
interface Figura {
    public double obwod();
    public double pole();
}
abstract class Figury implements Figura{
    public abstract void nazwa();
}
abstract class Czworokat extends Figury{
    public double bok1, bok2,bok3, bok4, kat;
}
class Kwadrat extends Czworokat{
    public void nazwa(){
        System.out.println("kwadrat:");
    }
    public double obwod(){
        return 4*bok1;
    }
    public double pole(){
        return bok1*bok1;
    }
}// <3 <3
class Prostokat extends Czworokat{
    public void nazwa(){
        System.out.println("prostokat:");
    }
    public double obwod(){
        return bok1+bok2+bok3+bok4;
    }
    public double pole(){
        if(bok1==bok2)
            return bok1*bok3;
        else
            return bok1*bok2;
    }
}
class Romb extends Czworokat{
    public void nazwa(){
        System.out.println("romb:");
    }
    public double obwod(){
        return 4*bok1;
    }
    public double pole() {
        return bok1*bok1*sin(kat*Math.PI/180);
    }
}
class Kolo extends Figury{
    public void nazwa(){
        System.out.println("kolo:");
    }
    public double promien;
    public double obwod(){
        return 2*Math.PI*promien;
    }
    public double pole(){
        return Math.PI*promien*promien;
    }
}
class Pieciokat extends Figury{
    public void nazwa(){
        System.out.println("pieciokat:");
    }
    public double bok;
    public double obwod(){
        return 5*bok;
    }
    public double pole(){
        return (bok*bok*sqrt(25+10*sqrt(5)))/4;
    }
}
class Szesciokat extends Figury{
    public void nazwa(){
        System.out.println("szesciokat:");
    }
    public double bok;
    public double obwod(){
        return 6*bok;
    }
    public double pole(){
        return (3*bok*bok*sqrt(3))/2;
    }
}
public class Figury_Test {
    public static void main(String[] args) {
        double a;
        int suma=0, wskaznik=1;
        Figury f[]=new Figury[args[0].length()];
        for(int i=0; i<args[0].length(); i++) {
            if(args[0].charAt(i)=='o')
                suma++;
            if(args[0].charAt(i)=='p')
                suma++;
            if(args[0].charAt(i)=='s')
                suma++;
            if(args[0].charAt(i)=='c')
                suma=suma+5;
            if(args[0].charAt(i)!='c'&& args[0].charAt(i)!='s' &&args[0].charAt(i)!='p' &&args[0].charAt(i)!='o'){
                System.out.println("Nieprawidlowe dane - zle nazwy figur");
                System.exit(1);
            }
        }
        if(suma!=args.length-1) {
            System.out.println("Nieprawidlowe dane - zla ilosc parametrow");
            System.exit(1);
        }
        for(int h=0; h<args[0].length(); h++) {
            if (args[0].charAt(h) == 'o') {
                try {
                    a = Double.parseDouble(args[wskaznik]);
                    Kolo k = new Kolo();
                    k.promien = a;
                    f[h] = k;
                } catch (NumberFormatException ex) {
                    System.out.println("Bledna dana");
                }
                wskaznik++;
            }
            if (args[0].charAt(h) == 'p') {
                try {
                    a = Double.parseDouble(args[wskaznik]);
                    Pieciokat piec = new Pieciokat();
                    piec.bok = a;
                    f[h] = piec;
                } catch (NumberFormatException ex) {
                    System.out.println("Bledna dana");
                }
                wskaznik++;
            }
            if (args[0].charAt(h) == 's') {
                try {
                    a = Double.parseDouble(args[wskaznik]);
                    Szesciokat s = new Szesciokat();
                    s.bok = a;
                    f[h] = s;
                } catch (NumberFormatException ex) {
                    System.out.println("Bledna dana");
                }
                wskaznik++;
            }
            if (args[0].charAt(h) == 'c') {
                if (wskaznik+ 4 < args.length && (((args[wskaznik].equals(args[wskaznik+1])) && (args[wskaznik+1].equals(args[wskaznik+2])))
                                                  && args[wskaznik + 2].equals(args[wskaznik + 3]))) {
                    if (Double.parseDouble(args[wskaznik + 4]) == 90) {
                        Kwadrat kw = new Kwadrat();
                        kw.bok1 = Double.parseDouble(args[wskaznik]);
                        kw.bok2 = Double.parseDouble(args[wskaznik + 1]);
                        kw.bok3 = Double.parseDouble(args[wskaznik + 2]);
                        kw.bok4 = Double.parseDouble(args[wskaznik + 3]);
                        f[h] = kw;
                    }else 
                    if (Double.parseDouble(args[wskaznik + 4]) > 0 && Double.parseDouble(args[wskaznik + 4]) < 180
                        &&Double.parseDouble(args[wskaznik + 4]) != 90) {
                        Romb r = new Romb();
                        r.bok1 = Double.parseDouble(args[wskaznik]);
                        r.bok2 = Double.parseDouble(args[wskaznik + 1]);
                        r.bok3 = Double.parseDouble(args[wskaznik + 2]);
                        r.bok4 = Double.parseDouble(args[wskaznik + 3]);
                        r.kat = Double.parseDouble(args[wskaznik + 4]);
                        f[h] = r;
                    }
                    wskaznik=wskaznik+5;
                }else
                if (wskaznik + 4 < args.length && (((args[wskaznik].equals(args[wskaznik + 1])) && (args[wskaznik + 2].equals(args[wskaznik + 3])))
                                                   || (args[wskaznik].equals(args[wskaznik + 2])&&args[wskaznik + 1].equals(args[wskaznik + 3]))
                                                   || (args[wskaznik + 1].equals(args[wskaznik + 2])&&args[wskaznik].equals(args[wskaznik + 3])))) {
                    if (Double.parseDouble(args[wskaznik + 4]) == 90) {
                        Prostokat pr = new Prostokat();
                        pr.bok1 = Double.parseDouble(args[wskaznik]);
                        pr.bok2 = Double.parseDouble(args[wskaznik + 1]);
                        pr.bok3 = Double.parseDouble(args[wskaznik + 2]);
                        pr.bok4 = Double.parseDouble(args[wskaznik + 3]);
                        f[h] = pr;
                    }
                    else
                        System.out.println("Bledna dana");
                    wskaznik=wskaznik+5;
                }
            }
        }
        for (int i = 0; i < args[0].length(); i++) {
            f[i].nazwa();
            System.out.printf("Pole = %f\n", f[i].pole());
            System.out.printf("Obwód = %f\n", f[i].obwod());
            System.out.println();
        }
    }
}
