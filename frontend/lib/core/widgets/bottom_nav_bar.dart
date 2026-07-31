import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class BottomNavBar extends StatelessWidget {
  final int currentIndex;
  final ValueChanged<int> onTap;
  const BottomNavBar({
    super.key,
    required this.currentIndex,
    required this.onTap,
  });

  static const _items = [
    _NavItemData(icon: FontAwesomeIcons.houseUser, label: 'Home'),
    _NavItemData(icon: FontAwesomeIcons.ticket, label: 'Booking'),
    _NavItemData(icon: FontAwesomeIcons.phone, label: 'Contact'),
    _NavItemData(icon: FontAwesomeIcons.circleUser, label: 'Me'),
  ];

  @override
  Widget build(BuildContext context) {
    return DecoratedBox(
      decoration: BoxDecoration(color: Colors.white),
      child: SafeArea(
        top: false,
        child: SizedBox(
          height: 64,
          child: Padding(
            padding: const EdgeInsets.only(top: 10),
            child: Row(
              children: List.generate(_items.length, (index) {
                final item = _items[index];
                final isActive = index == currentIndex;
                return Expanded(
                  child: InkWell(
                    onTap: () => onTap(index),
                    child: Column(
                      children: [
                        Icon(
                          item.icon.data,
                          color: isActive
                              ? Color(0xFF3DDC97)
                              : Color(0xFF9AA0A6),
                        ),
                        Text(
                          item.label,
                          style: TextStyle(
                            color: isActive
                                ? Color(0xFF3DDC97)
                                : Color(0xFF9AA0A6),
                          ),
                        ),
                      ],
                    ),
                  ),
                );
              }),
            ),
          ),
        ),
      ),
    );
  }
}

class _NavItemData {
  final FaIconData icon;
  final String label;
  const _NavItemData({required this.icon, required this.label});
}
