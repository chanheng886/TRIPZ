import 'package:get/get.dart';

class HomeController extends GetxController {
  final RxInt selectTicketType = 0.obs;

  void selectTicket(int index) {
    selectTicketType.value = index;
  }
}
