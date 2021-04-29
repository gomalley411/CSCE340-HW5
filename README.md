/* *****************************************************************************
 *  Name:      
 *  NetID:    
 *
 *  Partner Name:     N/A
 *  Partner NetID:    N/A
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 5: Burrows-Wheeler

/* *****************************************************************************
 *  Which sorting algorithm did you use in CircularSuffixArray.java?
 *  Why did you choose it?
 **************************************************************************** */
I used key-indexed counting because it seemed like the most efficient way to sort the data.

/* *****************************************************************************
 *  How long does your implementation of the Burrows-Wheeler data compression
 *  algorithm (BurrowsWheeler + MoveToFront + Huffman) take to compress and
 *  expand mobydick.txt? What is the compression ratio (number of bytes in
 *  compressed message divided by the number of bytes in the message)?
 *  Compare the results to that for running Huffman alone and GNU 
 *  command-line utility Gzip.
 **************************************************************************** */

Algorithm       Compression time    Expansion time           Compression ratio
------------------------------------------------------------------------------
My program
Huffman alone                                         0.560 (667651 / 1191463)
gzip                            

See the Checklist for Bash commands to compress/expand.



/* *****************************************************************************
 *  What is the running time of each of the following methods as a function
 *  of the input size n and the alphabet size R, both in practice
 *  (on typical English text inputs) and in theory (in the worst case)?
 *  Use big Theta notation to simplify your answer (e.g., n, n + R, n log n,
 *  n log^2n n, n^2, or R n).
 *
 *  Include the time for sorting circular suffixes in Burrows-Wheeler
 *  transform().
 **************************************************************************** */

                                      typical            worst
---------------------------------------------------------------------
CircularSuffixArray constructor       n                  n
BurrowsWheeler transform()            2n^2+R             ?
BurrowsWheeler inverseTransform()     3n+2R              3n+2R
MoveToFront encode()                  n+R                2R???
MoveToFront decode()                  n+R                2R???
Huffman compress()                    n + R log R        n + R log R
Huffman expand()                      n                  n





/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
BurrowsWheeler is having an ArrayIndexOutOfBoundsException at line 64, but I can't figure out how to fix it...


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings and lectures, but do
 *  include any help from people (including
 *  classmates and friends) and attribute them by name.
 **************************************************************************** */
na

/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */
exception as described above, yet to be solved...


/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it. Additionally, you may include any suggestions
 *  for what to change or what to keep (assignments or otherwise) in future 
 *  semesters.
 **************************************************************************** */
na

/* *****************************************************************************
 *  Include the screenshots of your output.
 **************************************************************************** */
