import 'package:frontend/features/home/models/busmodel/bus_schedule_model.dart';
import 'package:frontend/features/home/services/bus/bus_schedule_service.dart';
import 'package:get/get.dart';

class BusScheduleViewModel extends GetxController {
  final BusScheduleService _service = BusScheduleService();

  final RxBool isLoading = false.obs;
  final RxString errorMessage = ''.obs;
  final RxList<BusScheduleModel> schedules = <BusScheduleModel>[].obs;

  Future<void> searchBusSchedule({
    required String fromLocation,
    required String toLocation,
    required String travelDate,
  }) async {
    isLoading.value = true;
    errorMessage.value = '';
    schedules.clear();
    try {
      final formattedDate = _formatDate(DateTime.parse(travelDate));
      final result = await _service.searchBusSchedule(
        fromLocation: fromLocation,
        toLocation: toLocation,
        travelDate: formattedDate,
      );
      if (result.isEmpty) {
        errorMessage.value =
            "No Bus Schedule Found For Selected Locations and Date";
      }
      schedules.value = result;
    } catch (e) {
      errorMessage.value = 'Failed to load bus schedule: $e';
    } finally {
      isLoading.value = false;
    }
  }

  String _formatDate(DateTime date) {
    final year = date.year.toString().padLeft(4, '0');
    final month = date.month.toString().padLeft(2, '0');
    final day = date.day.toString().padLeft(2, '0');
    return '$year-$month-$day';
  }
}
