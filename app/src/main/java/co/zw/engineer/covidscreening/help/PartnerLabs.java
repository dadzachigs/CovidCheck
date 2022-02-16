package co.zw.engineer.covidscreening.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.zw.engineer.covidscreening.R;


public class PartnerLabs extends Fragment implements View.OnClickListener{
        private Button call1;
        private Button app1;
        private Button call2;
        private Button app2;
        private Button call3;
        private Button app3;
        private Button call4;
        private Button app4;
    public PartnerLabs() {
            // Required empty public constructor
        }



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_partner_labs, container, false);
            call1=view.findViewById(R.id.call_lab);
            call2=view.findViewById(R.id.call_lab2);
            call3=view.findViewById(R.id.call_lab3);
            call4= view.findViewById(R.id.call_lab4);
            app1=view.findViewById(R.id.sms_lab);
            app2=view.findViewById(R.id.sms_lab2);
            app3=view.findViewById(R.id.sms_lab3);
            app4=view.findViewById(R.id.sms_lab4);



            call1.setOnClickListener(this);
            call2.setOnClickListener(this);
            call3.setOnClickListener(this);
            call4.setOnClickListener(this);
            app1.setOnClickListener(this);
            app2.setOnClickListener(this);
            app3.setOnClickListener(this);
            app4.setOnClickListener(this);



            return view;

        }
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.call_lab:
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:+263\t\n" +
                            "\n" +
                            "+263 783281175"));
                    getActivity().startActivity(i);
                    break;
                case R.id.sms_lab:
                    try {
                        String headerReceiver = "Covid-19 Problem";// Replace with your message.
                        String bodyMessageFormal = "Hi";// Replace with your message.
                        String whatsappContain = headerReceiver + bodyMessageFormal;
                        String trimToNumner = "+263\t\n" +
                                "\n" +
                                "731492866"; //10 digit number
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://wa.me/" + trimToNumner + "/?text=" + ""));
                        getActivity().startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
           /* case R.id.call_lab2:
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:+263772204157"));
                getActivity().startActivity(i2);
                break;



            case R.id.call_lab3:

                Intent i3 = new Intent(Intent.ACTION_DIAL);
                i3.setData(Uri.parse("tel:+263772204159"));
                getActivity().startActivity(i3);

                break;

            case R.id.call_lab4:
                Intent i4 = new Intent(Intent.ACTION_DIAL);
                i4.setData(Uri.parse("tel:+263772204595"));
                getActivity().startActivity(i4);
                break;*/

                case R.id.sms_lab2:

                /*try {
                    String headerReceiver = "Covid-19 Problem";// Replace with your message.
                    String bodyMessageFormal = "Hi";// Replace with your message.
                    String whatsappContain = headerReceiver + bodyMessageFormal;
                    String trimToNumner = "+263772204158"; //10 digit number
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/" + trimToNumner + "/?text=" + ""));
                    getActivity().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;*/

            /*case R.id.sms_lab3:
                try {
                    String headerReceiver = "Covid-19 Problem";// Replace with your message.
                    String bodyMessageFormal = "Hi";// Replace with your message.
                    String whatsappContain = headerReceiver + bodyMessageFormal;
                    String trimToNumner = "+263772204157"; //10 digit number
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/" + trimToNumner + "/?text=" + ""));
                    getActivity().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case R.id.sms_lab4:
                try {
                    String headerReceiver = "Covid-19 Problem";// Replace with your message.
                    String bodyMessageFormal = "Hi";// Replace with your message.
                    String whatsappContain = headerReceiver + bodyMessageFormal;
                    String trimToNumner = "+263772204155"; //10 digit number
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/" + trimToNumner + "/?text=" + ""));
                    getActivity().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;*/


                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }

        }
}