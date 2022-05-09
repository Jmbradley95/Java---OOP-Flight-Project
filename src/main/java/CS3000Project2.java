/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonat
 */

import javax.swing.*;


public class CS3000Project2 {
        
    public static void main(String [] args)
    {
        JFrame frame = new JFrame ();
        Object[] destinationOptions = {"Chicago, IL", "Los Angeles, CA", "New York City, NY"};
        Object[] flightClassOptions = {"First Class", "Business", "Economy"};
        
        String dn;
        String fc;
        String seats;
        int newSeats = 0;
        
         //******************************************************************
        
        Flight flight = null;
        dn = (String)JOptionPane.showInputDialog(frame, "Welcome to Bradley United \n" +
                                                        "Please select a destination: ",
                                                        "Bradley United Destination Selection", JOptionPane.PLAIN_MESSAGE, null, destinationOptions, destinationOptions[0]);
        while(flight == null)
       {   
         if(dn.equals(destinationOptions[0]))
        {
           flight = new ChicagoFlight();           
        }    
        else if(dn.equals(destinationOptions[1]))
        {
           flight = new LosAngelesFlight();
        }
        else if(dn.equals(destinationOptions[2]))
        {
           flight = new NewYorkFlight(); 
        }
       }
         //******************************************************************
         
         fc = (String)JOptionPane.showInputDialog(frame,"Please select a class type: ",
                                                           "Bradley United Class Selection", JOptionPane.PLAIN_MESSAGE, null, flightClassOptions, flightClassOptions[0]);
           
        //******************************************************************
        
        boolean repeat = true;
        while(repeat)
        {
            try{
                seats = (String)JOptionPane.showInputDialog(frame, "Please enter the amount of tickets you want ");
                if(seats == null){
                JOptionPane.showMessageDialog(frame, "Canceling");
                System.exit(0);
                }else
                {
                    
                }
                newSeats = Integer.parseInt(seats);
                repeat = false;
                if(newSeats < 1)
                {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
                    repeat = true;
                }
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
                repeat = true;
            }
        }
  
        flight.setDestination(dn);
        flight.setFlightClassType(fc);
        flight.setAmountoftickets(newSeats);
        flight.CalcCost(newSeats);
        double total = flight.getTotalPrice();
        String newTotal = String.format("%.02f", total);
        //******************************************************************
  
     JOptionPane.showMessageDialog(frame, "Flight Destination:       " + flight.getDestination()+ 
                                          "\nFlight Class:                 " + flight.getFlightClassType() + 
                                          "\nNumber of Tickets:       " + flight.getAmountoftickets() + 
                                          "\nYour total cost:            $" + newTotal,
                                          "Bradley United: Your Receipt",
                                          JOptionPane.INFORMATION_MESSAGE);
                          
       
       //******************************************************************
      
       System.exit(0);
    }
    
}

//***********************************************************
//***********************************************************

class Flight{
    
    private String destination;
    String flightClassType;
    private int amountoftickets;
    double pricePerTicket;
    
    double totalPrice;
    
    public Flight(){
        this.destination = "";
        this.flightClassType = "";
        this.amountoftickets = 0;
        this.pricePerTicket = 0.0;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightClassType() {
        return flightClassType;
    }

    public void setFlightClassType(String flightClassType) {
        this.flightClassType = flightClassType;
    }

    public int getAmountoftickets() {
        return amountoftickets;
    }

    public void setAmountoftickets(int amountoftickets) {
        
        this.amountoftickets = amountoftickets;
    }

    public double getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(double pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public double CalcCost(int amountOfTickets){
        
        if("First Class".equals(this.flightClassType))
        {
            this.pricePerTicket = 30.00;
            {
           if(amountOfTickets == 0)
           {
               return totalPrice;
           }
           else
           {
               totalPrice += 30.00;
               CalcCost(amountOfTickets - 1);
           }
            }
        }
        else if("Business".equals(this.flightClassType))
        {
            this.pricePerTicket = 25.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
               totalPrice += 25.00;
               CalcCost(amountOfTickets - 1);
                }
            }
        }
        else if("Economy".equals(this.flightClassType))
        {
            this.pricePerTicket = 20.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
                    totalPrice += 20.00;
                    CalcCost(amountOfTickets - 1);
                }
            }
        }
        
        return totalPrice;
    }
    
}

//***********************************************************

class ChicagoFlight extends Flight{
    
    public ChicagoFlight(){
        super();
    }
    
    @Override
    public double CalcCost(int amountOfTickets){
         
        if("First Class".equals(this.flightClassType))
        {
            this.pricePerTicket = 30.00;
            {
           if(amountOfTickets == 0)
           {
               return totalPrice;
           }
           else
           {
               totalPrice += 30.00;
               CalcCost(amountOfTickets - 1);
           }
            }
        }
        else if("Business".equals(this.flightClassType))
        {
            this.pricePerTicket = 25.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
               totalPrice += 25.00;
               CalcCost(amountOfTickets - 1);
                }
            }
        }
        else if("Economy".equals(this.flightClassType))
        {
            this.pricePerTicket = 20.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
                    totalPrice += 20.00;
                    CalcCost(amountOfTickets - 1);
                }
            }
        }
        
        return totalPrice;
    }    
}

//***********************************************************

class LosAngelesFlight extends Flight{
    
    public LosAngelesFlight(){
        super();
    }
    
    @Override
    public double CalcCost(int amountOfTickets){
               
        if("First Class".equals(this.flightClassType))
        {
            this.pricePerTicket = 35.00;
            {
           if(amountOfTickets == 0)
           {
               return totalPrice;
           }
           else
           {
               totalPrice += 35.00;
               CalcCost(amountOfTickets - 1);
           }
            }
        }
        else if("Business".equals(this.flightClassType))
        {
            this.pricePerTicket = 30.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
               totalPrice += 30.00;
               CalcCost(amountOfTickets - 1);
                }
            }
        }
        else if("Economy".equals(this.flightClassType))
        {
            this.pricePerTicket = 25.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
                    totalPrice += 25.00;
                    CalcCost(amountOfTickets - 1);
                }
            }
        }
    
        
        return totalPrice;
    }
}

//***********************************************************

class NewYorkFlight extends Flight{

    public NewYorkFlight(){
        super();   }
    
    @Override
    public double CalcCost(int amountOfTickets){
         
        if("First Class".equals(this.flightClassType))
        {
            this.pricePerTicket = 40.00;
            {
           if(amountOfTickets == 0)
           {
               return totalPrice;
           }
           else
           {
               totalPrice += 40.00;
               CalcCost(amountOfTickets - 1);
           }
            }
        }
        else if("Business".equals(this.flightClassType))
        {
            this.pricePerTicket = 35.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
               totalPrice += 35.00;
               CalcCost(amountOfTickets - 1);
                }
            }
        }
        else if("Economy".equals(this.flightClassType))
        {
            this.pricePerTicket = 30.00;
            {
                if(amountOfTickets == 0)
                {
                    return totalPrice;
                }
                else
                {
                    totalPrice += 30.00;
                    CalcCost(amountOfTickets - 1);
                }
            }
        }
        
        return totalPrice;
    }    
}
