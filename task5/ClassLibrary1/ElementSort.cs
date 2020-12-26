using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task5
{
    public class ElementSort
    {
        public int X { get; set; }
        public int Inf { get; set; }
        public Color Color {get; set;}
        public int Y { get; internal set; }
        public ElementSort(int x, int y, int value, Color color)
        {
            X = x;
            Y = y;
            Inf = value;
            Color = color;
        }
    }
}
