import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:remixicon/remixicon.dart';

class TicketTypeWidget extends StatelessWidget {
  final int selectIndex;
  final ValueChanged<int> onSelect;
  const TicketTypeWidget({
    super.key,
    required this.selectIndex,
    required this.onSelect,
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          child: _buildPill(
            label: "Bus Ticket",
            icon: RemixIcons.bus_2_fill,
            isActive: selectIndex == 0,
            onTab: () => onSelect(0),
          ),
        ),
        SizedBox(width: 10),
        Expanded(
          child: _buildPill(
            label: "Hotel Ticket",
            icon: RemixIcons.hotel_bed_fill,
            isActive: selectIndex == 1,
            onTab: () => onSelect(1),
          ),
        ),
      ],
    );
  }
}

Widget _buildPill({
  required String label,
  required IconData icon,
  required bool isActive,
  required VoidCallback onTab,
}) {
  return GestureDetector(
    onTap: onTab,
    child: Container(
      padding: EdgeInsets.all(10),
      height: 50,
      decoration: BoxDecoration(
        color: isActive ? Color(0xFF3DDC97) : Colors.white,
        borderRadius: BorderRadius.circular(20),
      ),
      child: Row(
        children: [
          Icon(icon, color: isActive ? Colors.white : Colors.black),
          SizedBox(width: 5),
          Text(
            label,
            style: GoogleFonts.dmSans(
              color: isActive ? Colors.white : Colors.black,
              fontWeight: isActive ? FontWeight.bold : FontWeight.normal,
            ),
          ),
        ],
      ),
    ),
  );
}
