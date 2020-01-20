public class School {
  private int qualifications [] ;

  School() {
    qualifications();
  }

  //
  // Three values for different 
  //  Qualifications types. 

  private void qualifications() {
    qualifications = new int[3];
    for (int i = 0; i<qualifications.length; i++) {
      qualifications[i] = 500 *((int)Math.pow(10, i)) ;
    }
  }


  public int getQualif( int index) {
    return (qualifications[index]);
  }
}
