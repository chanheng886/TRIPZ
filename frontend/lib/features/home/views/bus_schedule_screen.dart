import 'package:flutter/material.dart';
import 'package:frontend/features/home/viewmodels/bus_schedule_view_model.dart';
import 'package:get/get.dart';

class BusScheduleScreen extends StatelessWidget {
  BusScheduleScreen({super.key});

  final BusScheduleViewModel viewModel = Get.find<BusScheduleViewModel>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Obx(() {
        return ListView.builder(
          itemCount: viewModel.schedules.length,
          itemBuilder: (context, index) {
            return SizedBox(
              child: Column(
                children: [Text(viewModel.schedules[index].route), Text("")],
              ),
            );
          },
        );
      }),
    );
  }
}
