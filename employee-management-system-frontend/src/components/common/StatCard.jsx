const palette = {
  indigo: {
    tint: "#ffffff",
    bg: "#fee2e2",
    color: "#dc2626",
  },
  violet: {
    tint: "#ffffff",
    bg: "#ffedd5",
    color: "#ea580c",
  },
  emerald: {
    tint: "#ffffff",
    bg: "#dbeafe",
    color: "#2563eb",
  },
  amber: {
    tint: "#ffffff",
    bg: "#fef3c7",
    color: "#d97706",
  },
};

export default function StatCard({
  title,
  value,
  icon: Icon,
  color,
  subtitle,
}) {
  const style = palette[color] || palette.indigo;

  return (
    <div
      className="rounded-2xl border bg-white p-5 shadow-sm transition-all duration-300 hover:shadow-lg hover:-translate-y-1"
      style={{
        borderColor: "#f1f5f9",
      }}
    >
      <div className="flex justify-between items-start">
        <div>
          <p
            className="text-xs uppercase font-semibold tracking-wider"
            style={{ color: "#64748b" }}
          >
            {title}
          </p>

          <h2 className="mt-3 text-4xl font-bold" style={{ color: "#111827" }}>
            {typeof value === "number" ? value.toLocaleString() : value}
          </h2>

          {subtitle && (
            <p className="mt-2 text-sm" style={{ color: "#94a3b8" }}>
              {subtitle}
            </p>
          )}
        </div>
      </div>
    </div>
  );
}
