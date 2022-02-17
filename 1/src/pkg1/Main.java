package pkg1;

import java.util.Arrays;

class Array {

    private int[] a; // ref to array a
    int nElems = 0;
//--------------------------------------------------------------

    public Array(int size) // constructor
    {
	a = new int[size]; // create array
    }
//--------------------------------------------------------------

    public void insert(int value) // put element into array
    {
	a[nElems++] = value; // insert it and increment size

    }
//-----------------------------------------------------------

    public long getElem(int index) // get value
    {
	return a[index];
    }
//---------------------------------------

    public boolean find(int searchKey) // find specified value
    {
	int j;
	for (j = 0; j < nElems; j++) // for each element,
	{
	    if (a[j] == searchKey) // found item?
	    {
		break; // exit loop before end
	    }
	}
	if (j == nElems) // gone to end?
	{
	    return false; // yes, can’t find it
	} else {
	    return true; // no, found it
	}
    } // end find()
//-----------------------------------------------------------

    public boolean delete(int value) {
	int j;
	for (j = 0; j < nElems; j++) // look for it
	{
	    if (value == a[j]) {
		break;
	    }
	}
	if (j == nElems) // can’t find it
	{
	    return false;
	} else // found it
	{
	    for (int k = j; k < nElems; k++) // move higher ones down    
	    {
		a[k] = a[k + 1];
	    }
	    nElems--; // decrement size
	    return true;
	}
    } // end delete()
//-----------------------------------------------------------

    public void display() // displays array contents
    {
	for (int j = 0; j < nElems; j++) // for each element,
	{
	    System.out.print(a[j] + " "); // display it
	}
	System.out.println();
    }

    public void display(int fromIndex, int toIndex) // displays array contents
    {
	if (fromIndex <= toIndex && fromIndex >= 0 && toIndex <= nElems) {
	    for (int j = fromIndex; j <= toIndex; j++) // for each element,
	    {
		System.out.print(a[j] + " "); // display it
	    }
	    System.out.println();
	}
    }
 
    //Homework 1
    public void insertSorted(int value) // put element into array
    {
	Arrays.sort(a, 0, nElems);
	int j;
	for (j = 0; j < nElems; j++) // find where it goes
	{
	    if (a[j] > value) // (linear search)      
	    {
		break;
	    }
	}
	for (int k = nElems; k > j; k--) // move bigger ones up    
	{
	    a[k] = a[k - 1];
	}
	a[j] = value; // insert it
	nElems++; // increment size
    } // end insertSorted()
//-----------------------------------------------------------

    //Homework 2
    public void rotate(int key) {

	if (key > nElems) {
	    key = key % nElems;
	}

	int[] result = new int[nElems];  //   1 2 3 4 5

	for (int i = 0; i < key; i++) {
	    result[i] = a[nElems - key + i];   //4   5   
	}

	int index = 0;
	for (int i = key; i < nElems; i++) {    //4  5   1  2  3 
	    result[i] = a[index++];                  
	}
	a = result;
    }

// Challenge Question
    public void rotate2(int key) {
	for (int i = 0; i < key; i++) {
	    for (int j = nElems - 1; j > 0; j--) {         
		// move each number by 1 place
		int temp = a[j];//5
		a[j] = a[j - 1];
		a[j - 1] = temp;
	    }
	}

    }
}// end class 

class test {

    public static void main(String[] args) {
	//Testing
	Array a = new Array(10);
	a.insert(1);
	a.insert(2);
	a.insert(3);
	a.insert(4);
	a.insert(5);

	a.display();
	if (a.find(5)) {
	    System.out.println("Found 5 !");
	} else {
	    System.out.println("Not Found  !");
	}
	a.insert(8);
	a.display();
	a.delete(1);
	a.display();
	a.display(3, 4);
	a.insertSorted(9);
	a.display();
	a.rotate(2);
	a.display();
	a.rotate2(2);
	a.display();

    }
}
