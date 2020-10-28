public class ArrayCapacity {
    public boolean doCheckArray(String[][] a) throws MyArraySizeException {
        int SIZE = 4;
        for(int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                if (a.length != SIZE || a[i].length != SIZE) {
                    throw new MyArraySizeException("Введите массив размером " + SIZE + "х" + SIZE);
                }
            }
        }
        return true;
    }

    public boolean checkTypeOfValue(String[][] arr) throws MyArrayDataException {
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                char[] b = arr[i][j].toCharArray();
                for(int k = 0; k < b.length; k++){
                    if (!Character.isDigit(b[k])){
                        throw new MyArrayDataException("Элемент arr[" + i + "][" + j + "] = " + arr[i][j] + " невозможно привести к числовому типу!!!" );
                    }
                }
            }
        }
        return true;
    }
}
