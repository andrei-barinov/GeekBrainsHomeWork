public class ArrayCapacity {
    public boolean doCheckArray(String[][] a) throws MyArraySizeException {
        if (a.length != 4 || a[0].length != 4 || a[1].length != 4 || a[2].length != 4 || a[3].length != 4) {
            throw new MyArraySizeException("Введите массив размером 4х4");
        }
        return true;
    }

    public boolean checkTypeOfValue(String[][] arr) throws MyArrayDataException {
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
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
