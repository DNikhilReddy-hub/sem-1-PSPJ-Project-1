import java.util.Scanner;

class restaurant_billing_system {
    int[] item_code = {301, 101, 102, 103, 104, 105, 201, 202, 203, 204};
    String[] item_name = {"Egg Bhurji", "Chicken Biryani", "Chicken Noodles", "Mutton Biryani", "Chicken Lolipop", "Chicken Tandori", "Paneer Tikka", "Methi Chaman", "Palak Paneer", "Paneer Butter Masala"};
    double[] item_price = {110.00, 220.00, 120.00, 240.00, 160.00, 240.00, 120.00, 240.00, 160.00, 210.00};
    int[] item_qty = new int[10];
    double total_amount = 0;


    void displayCategories() {
        System.out.println("=== MENU CATEGORIES ===");
        System.out.println("1. Non-Veg");
        System.out.println("2. Veg");
        System.out.println("3. Eggitarian");
        System.out.println("4. All");
    }
    void showMenu(int type) {
        int i;
        switch (type) {
            case 1:
                i = 1;
                while (i <= 5) {
                    System.out.println(item_code[i] + ". " + item_name[i] + " = " + item_price[i]);
                    i++;
                }
                break;
            case 2:
                i = 6;
                while (i <= 9) {
                    System.out.println(item_code[i] + ". " + item_name[i] + " = " + item_price[i]);
                    i++;
                }
                break;
            case 3:
                System.out.println(item_code[0] + ". " + item_name[0] + " = " + item_price[0]);
                break;
            case 4:
                i = 0;
                while (i <= 9) {
                    System.out.println(item_code[i] + ". " + item_name[i] + " = " + item_price[i]);
                    i++;
                }
                break;
            default:
                System.out.println("Wrong Type Selected");
        }
    }

    void addOrder(int selectedItem, int qty) {
        int i = 0;
        boolean found = false;

        while (i < item_code.length && !found) {
            if (item_code[i] == selectedItem) {
                found = true;
            } else {
                i++;
            }
        }

        if (found) {
            item_qty[i] += qty;
            total_amount += (item_price[i] * qty);
            System.out.println(qty + " x " + item_name[i] + " added. Subtotal: " + total_amount);
        } else {
            System.out.println("Invalid Code. Please try again.");
        }
    }

    void printFinalBill() {
        if (total_amount > 0) {
            double service_tax = total_amount * 0.05;
            double gst = (total_amount * 0.18);

            System.out.println("=============== FINAL BILL ===============");
            System.out.println("item              qty        price     final price");

            int i = 0;
            while (i < item_code.length) {
                if (item_qty[i] > 0) {
                    System.out.println(item_name[i] + "    " + item_qty[i] + "         " + item_price[i] + "         " + (item_qty[i] * item_price[i]));
                }
                i++;
            }

            double final_ammount = total_amount + service_tax + gst;

            System.out.println("--------------------------------");
            System.out.println("Subtotal:         " + total_amount);
            System.out.println("Service Tax:      " + service_tax);
            System.out.println("GST (18%):        " + gst);
            System.out.println("--------------------------------");
            System.out.println("Total Due:   Rs   " + final_ammount);
            System.out.println("You Have  earned a Copoun Worth 100 In Movie Ticket From Group6 theater");
            System.out.println("Copoun = Enjoy100G6");
            System.out.println("Contact Group 6 For Further Info");
            System.out.println("================================");
        } else {
            System.out.println("No items were ordered.");
        }
    }

    void main() {
        restaurant_billing_system billing = new restaurant_billing_system();
        Scanner sc = new Scanner(System.in);

        billing.displayCategories();

        System.out.print("Enter The Type (1-4): ");
        int type = sc.nextInt();

        System.out.println("=======================");
        System.out.println("          MENU         ");
        System.out.println("=======================");

        billing.showMenu(type);

        System.out.println("============================");

        boolean Ordering = true;


        while (Ordering) {
            System.out.print("Enter Item Code (or 0 to Generate Bill): ");
            int selectedItem = sc.nextInt();

            if (selectedItem == 0) {
                Ordering = false;
                continue;
            }

            System.out.print("Enter the quantity: ");
            int qty = sc.nextInt();

            billing.addOrder(selectedItem, qty);
        }

        billing.printFinalBill();
        sc.close();
    }
}