import java.util.Scanner;

public class Grafo {
    int a_matriz[][];
    int a_ruta[];
    int a_nivel, a_EI,a_EF,a_EA;
    Energizer Bateria;
    public static void main(String[] args) {
        Grafo Objects = new Grafo();
    }
    void m_procesa(){
        Bateria=new Energizer();
        nodo temp;
        boolean bandexito=false;
        Bateria.push(a_EI,0);
        do{
        temp=Bateria.pop();
        a_EA=temp.info;
        a_nivel=temp.nivel;
        a_ruta[a_nivel]=a_EA;
        if(a_EA==a_EF)
            bandexito=true;
        else
            expandir(a_EA,a_nivel+1);}while(Bateria.a_tope!=null&&!bandexito);
        if(bandexito)
        System.out.println("Si hay ruta");
        else
            System.out.println("No hay ruta");
    }
    void expandir(int p_vertice,int p_niveHijo){
        int v_columna;
        for(v_columna=0;v_columna<a_matriz.length;v_columna++)
            if(a_matriz[p_vertice][v_columna]==1&&!No_en_ruta(v_columna))
                Bateria.push(v_columna,p_niveHijo);
    }
    boolean No_en_ruta(int p_vertice){
        int v_posicion=0;
        while(v_posicion<a_nivel&&a_ruta[v_posicion]!=p_vertice)
            v_posicion++;
        if (a_ruta[v_posicion]!=p_vertice)
            return true;
        else
            return false;
    }
    void m_leerDatos(){
        Scanner teclado=new Scanner(System.in);
           //Neogram.com
        int v_reng,v_colu;
        int v_tama= teclado.nextInt();
        a_matriz=new int[v_tama][v_tama];
        a_ruta=new int[v_tama];
        a_nivel=0;
        for(v_reng=0;v_reng<v_tama;v_reng++)
            for(v_colu=0;v_colu<v_tama;v_colu++)
                a_matriz[v_reng][v_colu]=teclado.nextInt();
            a_EI=teclado.nextInt();
            a_EF=teclado.nextInt();
    }
}
class Energizer{
    nodo a_tope;
    Energizer(){
        a_tope=null;
    }
    void push(int dato, int nivNodo){
        nodo aux=new nodo(dato,nivNodo);
        if(a_tope==null)
            a_tope=aux;
        else{
            aux.siguiente=a_tope;
            a_tope=aux;
        }
    }
    nodo pop(){
        nodo tmp=null;
        if (a_tope!=null){

        }
        return tmp;
    }
}
class nodo{
    int info, nivel;
    nodo siguiente;
    nodo(int p_info,int p_nivel){
        info=p_info;siguiente=null;nivel=p_nivel;
    }
}
//roUi0rtd3!

