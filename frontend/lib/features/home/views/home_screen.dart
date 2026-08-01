import 'package:flutter/material.dart';
import 'package:frontend/features/home/views/search_bus_location_screen.dart';
import 'package:frontend/features/home/widgets/home_widgets/app_bar_widget.dart';
import 'package:frontend/features/home/widgets/home_widgets/input_date_time_widget.dart';
import 'package:frontend/features/home/widgets/home_widgets/input_field_widget.dart';
import 'package:frontend/features/home/widgets/home_widgets/ticket_type_widget.dart';
import 'package:frontend/features/shell/controllers/home_controller.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:remixicon/remixicon.dart';

class HomeScreen extends StatelessWidget {
  final TextEditingController fromWhereController;
  final TextEditingController toWhereController;
  final TextEditingController leavingDateController;
  HomeScreen({
    super.key,
    required this.fromWhereController,
    required this.toWhereController,
    required this.leavingDateController,
  });
  final HomeController controller = Get.put(HomeController());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SingleChildScrollView(
        child: Column(
          children: [
            // ✅✅ App Bar Widget
            AppBarWidget(
              imageUrl:
                  "https://i.pinimg.com/736x/da/e7/d6/dae7d6ab8e2abd3e74d776a5fd49a6cb.jpg",
              userName: "Chan",
            ),

            //✅✅ Tab Bar View
            SizedBox(height: 10),
            Padding(
              padding: const EdgeInsets.only(left: 10, right: 10),
              child: SizedBox(
                child: Column(
                  children: [
                    Obx(
                      () => TicketTypeWidget(
                        selectIndex: controller.selectTicketType.value,
                        onSelect: controller.selectTicket,
                      ),
                    ),
                    SizedBox(height: 10),
                    Obx(
                      () => controller.selectTicketType.value == 0
                          //✅✅ Bus Booking Ticket
                          ? Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Container(
                                  width: double.infinity,
                                  decoration: BoxDecoration(
                                    border: Border.all(
                                      color: Colors.grey.shade100,
                                    ),
                                    color: Colors.white,
                                    borderRadius: BorderRadius.circular(20),
                                    boxShadow: [
                                      BoxShadow(
                                        color: Colors.grey.shade200,
                                        blurRadius: 2,
                                        offset: Offset(0, 2),
                                      ),
                                    ],
                                  ),
                                  child: Padding(
                                    padding: const EdgeInsets.all(10),
                                    child: Column(
                                      mainAxisSize: MainAxisSize.min,
                                      children: [
                                        //✅✅ 1. Select Departure Location
                                        InputFieldWidget(
                                          leading: RemixIcons.treasure_map_line,
                                          title: "From",
                                          locationController:
                                              fromWhereController,
                                          page: SearchBusLocationScreen(
                                            searchLocationController:
                                                fromWhereController,
                                          ),
                                          trailingIcon:
                                              RemixIcons.arrow_up_down_line,
                                        ),
                                        SizedBox(height: 10),
                                        //✅✅2. Select Arrivals Location
                                        InputFieldWidget(
                                          leading: RemixIcons.map_pin_line,
                                          title: "To",
                                          locationController: toWhereController,
                                          page: SearchBusLocationScreen(
                                            searchLocationController:
                                                toWhereController,
                                          ),
                                        ),
                                        SizedBox(height: 10),
                                        //✅✅ 3 Select Departure Time
                                        InputDateTimeWidget(
                                          leading: RemixIcons.calendar_2_line,
                                          title: "Leaving",
                                          dateController: leavingDateController,
                                        ),
                                        SizedBox(height: 10),
                                        Row(
                                          mainAxisAlignment:
                                              MainAxisAlignment.spaceBetween,
                                          children: [
                                            // ✅✅ 4 Select Leaving Date
                                            Flexible(
                                              fit: FlexFit.loose,
                                              child: InputDateTimeWidget(
                                                leading:
                                                    RemixIcons.calendar_2_line,
                                                title: "Leaving",
                                              ),
                                            ),
                                            SizedBox(width: 10),
                                            // ✅✅ Select Return Date (optional for user)
                                            Container(
                                              width: 120,
                                              height: 60,
                                              decoration: BoxDecoration(
                                                color: Colors.green,
                                                borderRadius:
                                                    BorderRadius.circular(15),
                                              ),
                                              child: TextButton(
                                                onPressed: () {},
                                                child: Text(
                                                  "Find Bus",
                                                  style: GoogleFonts.dmSans(
                                                    fontSize: 18,
                                                    color: Colors.white,
                                                    fontWeight: FontWeight.bold,
                                                  ),
                                                ),
                                              ),
                                            ),
                                          ],
                                        ),
                                      ],
                                    ),
                                  ),
                                ),
                                SizedBox(height: 10),
                                Text(
                                  "Our Location",
                                  style: GoogleFonts.dmSans(
                                    fontSize: 18,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                                ClipRRect(
                                  borderRadius: BorderRadius.all(
                                    Radius.circular(15),
                                  ),
                                  child: SizedBox(
                                    height: 150,
                                    child: ListView.builder(
                                      itemCount: 4,
                                      scrollDirection: Axis.horizontal,
                                      itemBuilder: (context, index) {
                                        return Padding(
                                          padding: const EdgeInsets.only(
                                            right: 5,
                                          ),
                                          child: Container(
                                            width: 250,
                                            decoration: BoxDecoration(
                                              color: Colors.green,
                                              borderRadius:
                                                  BorderRadius.circular(15),
                                            ),
                                            child: Center(child: Text("Hello")),
                                          ),
                                        );
                                      },
                                    ),
                                  ),
                                ),
                              ],
                            )
                          : Container(
                              width: double.infinity,
                              height: 300,
                              color: Colors.green,
                              child: Text("Bus Booking"),
                            ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
