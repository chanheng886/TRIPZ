import 'package:flutter/material.dart';
import 'package:frontend/features/home/views/search_bus_location_screen.dart';
import 'package:frontend/features/home/widgets/app_bar_widget.dart';
import 'package:frontend/features/home/widgets/ticket_type_widget.dart';
import 'package:frontend/features/shell/controllers/home_controller.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:remixicon/remixicon.dart';

class HomeScreen extends StatelessWidget {
  HomeScreen({super.key});
  final HomeController controller = Get.put(HomeController());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Column(
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
                        ? Container(
                            width: double.infinity,
                            height: 300,
                            decoration: BoxDecoration(
                              border: Border.all(color: Colors.grey.shade100),
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
                                children: [
                                  //✅✅ 1. First Text Field
                                  _InputField(
                                    page: SearchBusLocationScreen(),
                                    leading: RemixIcons.treasure_map_line,
                                    title: "From",
                                    subTitle: "Phnom Penh",
                                  ),
                                ],
                              ),
                            ),
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
    );
  }
}

Widget _InputField({
  required String title,
  required String subTitle,
  required IconData leading,
  Widget? page,
  IconButton? trialling,
  IconData? trialingIcon,
}) {
  return
  //✅✅ 1. First Text Field
  InkWell(
    onTap: () {
      Get.to(page);
    },
    child: Container(
      decoration: BoxDecoration(
        color: Color(0xffF4F4F7),
        borderRadius: BorderRadius.circular(15),
      ),
      child: ListTile(
        leading: Icon(leading),
        title: Text(title, style: GoogleFonts.dmSans(fontSize: 20)),
        subtitle: Text(subTitle, style: GoogleFonts.dmSans(fontSize: 16)),
        trailing: trialling != null
            ? CircleAvatar(
                backgroundColor: Color(0xff4FD18B),
                radius: 22,
                child: IconButton(onPressed: () {}, icon: Icon(trialingIcon)),
              )
            : null,
      ),
    ),
  );
}
