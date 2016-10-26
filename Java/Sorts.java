public class Sorts {
    
    public void bubbleSort(int[] array){
        int aux;
        boolean cambios = false;
        while(true){
            cambios=false;
            for(int i=1;i<array.length;i++){
                if(array[i]<array[i-1]){
                    aux=array[i];
                    array[i] = array[i-1];
                    array[i-1] = aux;
                    cambios = true;
                }
            }
            if(cambios==false){
                break;
            }
        }
    }
    
    public void insertionSort(int[] array){
        int aux,cont1,cont2;
        for(cont1 = 1; cont1<array.length;cont1++){
            aux = array[cont1];
            for(cont2=cont1-1;cont2 >=0 && array[cont2]>aux;cont2--){
                array[cont2+1]=array[cont2];
                array[cont2]=aux;
            }
        }
    }
    
    public void quickSort(int[] array){
        array = quickSortAux1(array);
    }
    
    public int[] quickSortAux1 (int numbers[]){
        return quickSortAux2(numbers,0,numbers.length-1);
    }
    
    public int[] quickSortAux2 (int numbers[], int left, int right){
        if(left>=right){
            return numbers;
        }
        int i=left,d=right;
        if(left!=right){
            int pivote;
            int aux;
            pivote = left;
            while(left!=right){
                while(numbers[right]>=numbers[pivote] && left<right){
                    right--;
                }
                while(numbers[left]<numbers[pivote] && left<right){
                    left++;
                }
                if(right!=left){
                    aux = numbers[right];
                    numbers[right] = numbers[left];
                    numbers[left] = aux;
                }
            }
            if(left==right){
                quickSortAux2(numbers,i,left-1);
                quickSortAux2(numbers,left+1,d);
            }
        }else{
            return numbers;
        }
        return numbers;
    }
    
}
