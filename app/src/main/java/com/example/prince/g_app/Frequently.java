package com.example.prince.g_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Frequently extends AppCompatActivity {
    public ListView lvf;
    ArrayList<Freq_model> freqlist = new ArrayList<>();
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequently);

        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Freq_adapter listAdapter = new Freq_adapter(this, freqlist);
        lvf = (ListView) findViewById(R.id.lvf);
        lvf.setAdapter(listAdapter);

        Freq_model freq_item = new Freq_model("O1: For how many GATE papers can I apply?", "Answer: A candidate can apply for only ONE of the 23" +
                "papers listed in the GATE INFORMATION BROCHURE or GATE website.");
        freqlist.add(freq_item);

        freq_item = new Freq_model("02: After submission of application, am I permitted to change my GATE Examination paper and Examination City?", "Answer: It is not possible" +
                "to change the GATE examination paper after the application is submitted.Please select your choice examination paper carefully.Request for change of examination city will be accepted with a fee of Rs.400/- to be paid online using GOAPS.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("03: Will I be provided with any white paper for rough qwork and calculations during the test","Answer: A Scribble pad will be provided to the candidate that can be used to do the rough work.The candidate has to return the scribble pad after the examination");
        freqlist.add(freq_item);

        freq_item=new Freq_model("04: Am I allowed to leave the examination hall during the test?","Answer: NO Candidates will NOT be allowed to leave the examination hall for any reason during the test.Candidates are allowed to leave the computer laboratory where the exam will be conducted only after the closure of the text at the scheduled end of examination in a session.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("05: What seems are not permitted to be brought with the inside the examination venue?","Answer: Electronic diary, mobile phone, and any such electronic gadgets, blank papers, clip boards and log-tables will not be allowed in the examination venue.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("06: Can I use a calculator during the examination?","Answer: No. An online virtual calculator will be available to examinees at the time of examination.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("07: Will be there any arrangement at the test center for the safe keeping of my personal items such as my mobile phone?","Answer: NO. Such arrangements will not be possible at the test center.");
        freqlist.add(freq_item);

        freq_item= new Freq_model("08: When will I receive my admit card?","Answer: Admit card can only be downloaded from the GOAPS website. Admit Cards will NOT be sent by post.");
        freqlist.add(freq_item);

        freq_item= new Freq_model("08: Can I use one e-mail address to fill multiple application forms?","Answer: NO, one e-mail address can be used to submit only one application form");
        freqlist.add(freq_item);

        freq_item= new Freq_model("09: Why should I choose three examination cities?","Answer: Generally you will be alloted a centre in the examination city of your first choice.Only in case where it becomes difficult to accomodate you in the examination city of your first choice,your other two choices will be considered.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("10: My power/internet connection failed during the application process, what do I do?","Answer: If you have clicked on the SAVE button during the application process, the data you entered up to that point of time has been stored online.Simply login back to the GATE application website and continue the application process.Otherwise, you have to start the process afresh");
        freqlist.add(freq_item);

        freq_item=new Freq_model("11: How do I make the fee payment for GATE examination?","Answer: You can make the payment during the ONLINE application process by choosing the following option:\na). Online Payment: Net Banking through the payment gateway.\nb)e-challan: e-challan of State Bank of India.");
        freqlist.add(freq_item);

        freq_item= new Freq_model("12: My power/internet connection failed during online payment. What do I do? ","Answer: When you can get back online, first check the status of your payment on the GATE application website.\na)If the payment was received by GATE, you can continue the process of printing the application form.\nb)If the payment was not reeived by GATE,you have to start with the payment step again, to complete payment.");
        freqlist.add(freq_item);

        freq_item= new Freq_model("13: My net banking account has been debited (money taken out) more than once.How do i get the money back?","Answer: This can happen if your bank account was used more than once or you pressed refresh or back button of your internet browser.Any unaccounted or excess money that was received on behalf of GATE from this account will automatically be returned(creited) to the same bank account.");
        freqlist.add(freq_item);

        freq_item= new Freq_model("14: My bank account has been debited,but GATE Application website says that the payment has not been received.What do I do?","Answer: This happens because of some failure in internet transaction. Within 72 Hr. GATE Application website shows that the payment is success,You will be charged only once, Any excess/unaccounted debits will be returned to you.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("15: If I want the Bank challan option, how should I complete the application process?","Answer: If you select the e-challan option, then you will have to print the generated challan and will have to go to a branch of the State Bank of India and pay.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("16: Do I have to send the print-out of the application form?","Answer: NO");
        freqlist.add(freq_item);

        freq_item=new Freq_model("17: Whwn and how will i know the status of my application?","Answer: You can check the status of your application by logging onto GOApS website.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("18: I have missed to take a print out of my ONLINE application at the end of my application process.How will I get access to it?","Answer: You can login using GOAPS Enrolment ID and password and take a printout.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("19: After completing the ONLINE application process and generating a PDF file, will I be able to change my application data? ","Answer: NO.After completing all the steps upto PDF application form generation in the ONLINE application process,you can only download the aplication form and CANNOT modify the data. Hence you need to be very careful while entering the data. You may also save a partially filled application aand login in again at a later point in time to complete and submit the application, however it must be within specified deadline.");
        freqlist.add(freq_item);

        freq_item=new Freq_model("20; If I want the Online Payment (Net-banking) option,how should I complete the application the application process?","Answer: After filling all the fields in the ONLINE application form, choose the online Payment option and proceed for payment ny following the instructions.Your browser screen will be re-direct you to the bank you choose.Login with your Internet Banking credentials and confirm the payment. After confirming the payment. you will be re-directed back to the GATE application website. At the end this process, you can download a PDF file will be generated with the necessary details of the candidates, like full name,date of birth (DoB), scanned photograph, sex, category(GE/OBC/SC/ST), PwD (Y/N). full contact address,mobile number, email id, etc. Take a printout of the entire PDF file for your future reference/use");
        freqlist.add(freq_item);




        /* freq_item.setQuestion("Topics");
        freq_item.setAnswer("Links");

        freqlist.add(freq_item);
        freq_item.setQuestion("Topics2");
        freq_item.setAnswer("Links");

        freqlist.add(freq_item);*/

    }
}
