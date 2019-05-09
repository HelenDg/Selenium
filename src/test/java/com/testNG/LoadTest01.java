package com.testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.AfterClass;


public class LoadTest01 {
@Test
public void test1() {
	//TODO Auto-generated method stub
			List<Integer> a = new ArrayList<Integer>();
			List<Integer> b = new ArrayList<Integer>();
			check_arr(a);
			sort(a);
			check_arr(b);
			sort(b);
			compare_arr(a, b);
			
}

public void check_arr(List<Integer> arr)
{
	Scanner i = new Scanner(System.in);
	int numarr;
	do
	{
	   System.out.println("Enter the positive number of array:");
	   
	   while (!i.hasNextInt())
	   {
	   System.out.println("That wasn't an int number. Try again: ");
	   i.next();
	   }
	   numarr = i.nextInt();
	   
	} while (numarr <= 0);

	for (int z = 0; z< numarr; z++)
	{
		System.out.println("Enter the number " + z + " of array: ");
		arr.add(i.nextInt());
    }
}

public static void sort(List<Integer> arrtemp)
{
	 int min;
	 for (int i = 0; i< arrtemp.size(); i++)
	 {
		 for (int j = (i+1); j < arrtemp.size(); j++)
		 {
			 if (arrtemp.get(i) > arrtemp.get(j))
				{
					min = arrtemp.get(i);
					arrtemp.set(i, arrtemp.get(j));
					arrtemp.set(j, min);
				}
		 }
	 }
	 System.out.println(arrtemp);
}
public static void compare_arr(List<Integer> a1, List<Integer> a2) throws AssertionError
{ 
	if (a1.size() != a2.size())
	{
		System.out.println("2 arrays are non-identical"); 
		throw new AssertionError();
	}
	else
	{
		
		for (int i = 0; i < a1.size(); i++)
			 {
				 
			 if (a1.get(i)==a2.get(i)) 
				 {
					 System.out.println("The element of 2 arrays at " + i + " position is identical " + a1.get(i) + " = " + a2.get(i));
				 }	
			 else
				 {
					 System.out.println("The element of 2 arrays at " + i + " position is non-identical " + a1.get(i) + " # " + a2.get(i));
					 throw new AssertionError();
				 } 	 
			 }
		
	}
}
}