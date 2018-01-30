# BlueUI
BlueUi is aimed at creating an android liberary module which will enable faster and simpler UI developement . To add this module to youre android project either download this liberary or use ` git clone www.github.com/jemshid123/BlueUI `  command and then add the module as a dependency.
 
 <h2>View Pager with custom effects</h2>
 
 <p>This allows you to create a simple view pager with zoom out effect on swiping </p>
 <img src="img/viewpager.gif" alt="View Pager" />
 
To create a viewpager add a viewpager widget to youre XML Layout file 

         <android.support.v4.view.ViewPager
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:id="@+id/vp">
        </android.support.v4.view.ViewPager>
        
 Then create a viewpager object
 
     //creating initial fragments to be viewed
    Fragment fragment[]=new Fragment[]{new f1(),new f2()};
     // creating slidefragmentviewpageradapter as viewpageradapter  
    slideFragmentViewPagerAdapter slide=new slideFragmentViewPagerAdapter(getSupportFragmentManager(),fragment);
    ViewPager viewPager=(ViewPager)findViewById(R.id.vp);
    viewPager.setAdapter(slide);
    viewPager.setPageTransformer(false,new zoomOutPageTransformer());
    //page transformer adds effects. in this case Zoom out effect
    
 you can also add new fragments to the view pager dynamically at runtime
 
     slide.addFragment(new f1());
   
 
 
 

